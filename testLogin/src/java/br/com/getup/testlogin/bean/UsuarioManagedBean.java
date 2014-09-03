package br.com.getup.testlogin.bean;

import br.com.getup.testlogin.dao.UsuarioFacadeLocal;
import br.com.getup.testlogin.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author MarkusPatriota
 */
@Named
@RequestScoped
public class UsuarioManagedBean implements Serializable{

     @Inject
     private UsuarioFacadeLocal usuarioFacadeLocal;
     private List<Usuario> listUsuario;
     private Usuario usuario;
    /**
     * Creates a new instance of UsuarioManagedBean
     */
    public UsuarioManagedBean() {
       usuario= new Usuario();
    }
    
    public void cadastro(){
        usuarioFacadeLocal.create(usuario);
    }

    public String login(){
               
        if(isUsuarioValido()){
            return "/index.xhtml";
            
        }else{
            usuario= null;
            System.out.println("Errou no login!");
        }
        return "";
    }
    
    private boolean isUsuarioValido() {
        
        for (int i = 0; i < getListUsuario().size(); i++) {
                if(getListUsuario().get(i).getName().equals(usuario.getName()) && getListUsuario().get(i).getSenha().equals(usuario.getSenha())){
                    System.out.println("Senha correta");
                    return true;
             }
        }
        return false;
    }

    public UsuarioFacadeLocal getUsuarioFacadeLocal() {
        return usuarioFacadeLocal;
    }

    public void setUsuarioFacadeLocal(UsuarioFacadeLocal usuarioFacadeLocal) {
        this.usuarioFacadeLocal = usuarioFacadeLocal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListUsuario() {
        listUsuario= usuarioFacadeLocal.findAll();
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }
    
}
