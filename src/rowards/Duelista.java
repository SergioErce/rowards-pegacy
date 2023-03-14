package rowards;

public class Duelista {
	Mago mago;
	boolean habilidadOrden;
	boolean aturdido;
	
	
	public Duelista(Mago mago) {
		
		this.mago = mago;
		this.habilidadOrden = true;
		this.aturdido = false;
	}
	public Mago getMago() {
		return mago;
	}
	public void setMago(Mago mago) {
		this.mago = mago;
	}
	public boolean isHabilidadOrden() {
		return habilidadOrden;
	}
	public void setHabilidadOrden(boolean habilidadOrden) {
		this.habilidadOrden = habilidadOrden;
	}
	public boolean isAturdido() {
		return aturdido;
	}
	public void setAturdido(boolean aturdido) {
		this.aturdido = aturdido;
	}
	
}
