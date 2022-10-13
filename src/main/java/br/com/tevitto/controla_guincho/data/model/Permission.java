package br.com.tevitto.controla_guincho.data.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "permission")
public class Permission implements Serializable, GrantedAuthority {

    private static final Long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String description;

    @Column
    private int excluir;

    @Column
    private int editar;

    @Column
    private int visualizar;

    @Column
    private int criar;

    @ManyToMany(mappedBy = "permissions")
//    @LazyCollection(LazyCollectionOption.FALSE)
    List<UserSystem> users;

    public Permission() {
        super();
    }
	/*	(1, 'Adm Geral', 1, 1, 1, 1),
	(2, 'Normal', 0, 1, 1, 0),
	 * **/

    public List<UserSystem> getUsers() {
        return users;
    }

    public void setUsers(List<UserSystem> users) {
        this.users = users;
    }

    public int getExcluir() {
        return excluir;
    }

    public void setExcluir(int excluir) {
        this.excluir = excluir;
    }

    public int getEditar() {
        return editar;
    }

    public void setEditar(int editar) {
        this.editar = editar;
    }

    public int getVisualizar() {
        return visualizar;
    }

    public void setVisualizar(int visualizar) {
        this.visualizar = visualizar;
    }

    public int getCriar() {
        return criar;
    }

    public void setCriar(int criar) {
        this.criar = criar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getAuthority() {
        return this.description;
    }
}