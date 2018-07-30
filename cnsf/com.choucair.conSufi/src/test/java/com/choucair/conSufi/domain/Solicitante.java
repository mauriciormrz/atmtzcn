package com.choucair.conSufi.domain;


public class Solicitante {

    private int solicitante_id;
    private Integer application_id;
    private String nombre;
    private String apellido;
    private String tipo_documento;
    private String documento;
    private String celular;
    private String correo_electronico;
    
    public String getApplication_id() {
        return application_id.toString();
    }

    public void setSolicitante_id(int solicitante_id) {
        this.solicitante_id = solicitante_id;
    }
    
    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "[" + "solicitante_id=" + solicitante_id + ", application_id=" + application_id + ", nombre=" + nombre + ", apellido=" + apellido + ']';
    }

	public int getSolicitante_id() {
		return solicitante_id;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
}
