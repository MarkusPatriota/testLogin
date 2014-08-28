package br.com.getup.testlogin.bean;

import br.com.getup.testlogin.model.Usuario;

/**
 *
 * @author MarkusPatriota
 */
public interface UsuarioBeanIF {
    
    public Usuario isUsuario(String nome, String senha);
        
}
