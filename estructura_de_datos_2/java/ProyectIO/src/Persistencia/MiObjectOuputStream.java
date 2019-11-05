/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.IOException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author 57300
 */
public class MiObjectOuputStream extends ObjectOutputStream{
   public MiObjectOuputStream(final OutputStream out) throws IOException {
        super(out);
    }
    
    protected MiObjectOuputStream() throws IOException, SecurityException {
    }
    
    @Override
    protected void writeStreamHeader() throws IOException {
    }
}
