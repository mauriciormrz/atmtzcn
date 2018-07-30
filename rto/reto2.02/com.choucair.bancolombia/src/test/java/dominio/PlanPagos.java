package dominio;

public class PlanPagos {
	
	private String cuota;
	private String abonoIntereses;
	private String abonoCapital;
	private String cuotaMensualSinSeguros;
	private String valorSeguroVida;
	private String cuotaMensualConSeguros;
	private String saldo;
	
	public String getCuota() {
		return cuota;
	}
	
	public void setCuota(String cuota) {
		this.cuota = cuota;
	}
	
	public String getAbonoIntereses() {
		return abonoIntereses;
	}
	
	public void setAbonoIntereses(String abonoIntereses) {
		this.abonoIntereses = abonoIntereses;
	}
	
	public String getAbonoCapital() {
		return abonoCapital;
	}
	
	public void setAbonoCapital(String abonoCapital) {
		this.abonoCapital = abonoCapital;
	}
	
	public String getCuotaMensualSinSeguros() {
		return cuotaMensualSinSeguros;
	}
	
	public void setCuotaMensualSinSeguros(String cuotaMensualSinSeguros) {
		this.cuotaMensualSinSeguros = cuotaMensualSinSeguros;
	}
	
	public String getValorSeguroVida() {
		return valorSeguroVida;
	}
	
	public void setValorSeguroVida(String valorSeguroVida) {
		this.valorSeguroVida = valorSeguroVida;
	}
	
	public String getCuotaMensualConSeguros() {
		return cuotaMensualConSeguros;
	}
	
	public void setCuotaMensualConSeguros(String cuotaMensualConSeguros) {
		this.cuotaMensualConSeguros = cuotaMensualConSeguros;
	}
	
	public String getSaldo() {
		return saldo;
	}
	
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

}
