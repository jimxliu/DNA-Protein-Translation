package com.demo.translation;

import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.DNASequence; 
import org.biojava.nbio.core.sequence.RNASequence; 
import org.biojava.nbio.core.sequence.ProteinSequence; 
import org.biojava.nbio.core.sequence.transcription.TranscriptionEngine; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Translate {

    Logger logger = LoggerFactory.getLogger(Translate.class);

    private String input;
    private String result;    
    private String error;    

    public void setInput(String input){
        this.input = input.replaceAll("\\s+", "").toUpperCase();
    }
    
    public String getInput(){
        return input;
    }    


    public String getResult(){
        return result;
    }    

    public String getError() {
        return error;
    }

    public void translate(){
        result = null;
        error = null;
        try {
            TranscriptionEngine e = TranscriptionEngine.getDefault();
            DNASequence dna = new DNASequence(input);
            RNASequence rna = dna.getRNASequence(e);
            ProteinSequence protein = rna.getProteinSequence(e);
            result = protein.toString();            
            logger.info("Successfully translated");
        } catch (CompoundNotFoundException e){
            error = e.toString();
            logger.error(error);
            
        } catch (Exception e) {
            error = e.toString();
            logger.error(error);
        }
    }
}
