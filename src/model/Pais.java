package model;

public class Pais implements Comparable<Pais> {
	String nombre;
	private Medalla oroHombre;
	private Medalla plataHombre;
	private Medalla bronceHombre;
	private Medalla oroMujer;
	private Medalla plataMujer;
	private Medalla bronceMujer;
	private String orden;

	public Pais(String nombre, Medalla oroHombre, Medalla plataHombre, Medalla bronceHombre, Medalla oroMujer,
			Medalla plataMujer, Medalla bronceMujer, String orden) {
		this.nombre = nombre;
		this.setOroHombre(oroHombre);
		this.setPlataHombre(plataHombre);
		this.setBronceHombre(bronceHombre);
		this.setOroMujer(oroMujer);
		this.setPlataMujer(plataMujer);
		this.setBronceMujer(bronceMujer);
		this.setOrden(orden);
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Medalla getOroHombre() {
		return oroHombre;
	}

	public void setOroHombre(Medalla oroHombre) {
		this.oroHombre = oroHombre;
	}

	public Medalla getBronceHombre() {
		return bronceHombre;
	}

	public void setBronceHombre(Medalla bronceHombre) {
		this.bronceHombre = bronceHombre;
	}

	public Medalla getPlataHombre() {
		return plataHombre;
	}

	public void setPlataHombre(Medalla plataHombre) {
		this.plataHombre = plataHombre;
	}

	public Medalla getOroMujer() {
		return oroMujer;
	}

	public void setOroMujer(Medalla oroMujer) {
		this.oroMujer = oroMujer;
	}

	public Medalla getPlataMujer() {
		return plataMujer;
	}

	public void setPlataMujer(Medalla plataMujer) {
		this.plataMujer = plataMujer;
	}

	public Medalla getBronceMujer() {
		return bronceMujer;
	}

	public void setBronceMujer(Medalla bronceMujer) {
		this.bronceMujer = bronceMujer;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public int calcularMedallasDeOro() {

		int oros = oroHombre.getCantidad() + oroMujer.getCantidad();
		return oros;
	}

	public int calcularMedallasDePlata() {

		int platas = plataHombre.getCantidad() + plataMujer.getCantidad();
		return platas;
	}

	public int calcularMedallasDeBronce() {

		int bronces = bronceHombre.getCantidad() + bronceMujer.getCantidad();
		return bronces;
	}

	@Override
	public int compareTo(Pais i) {
		Pais A = this;
		Pais B = i;
		int output = 0;
		if (orden.equals("1")) {
			output = (int) (B.oroHombre.getCantidad() - A.oroHombre.getCantidad());
			if (output == 0) {
				output = (int) (B.plataHombre.getCantidad() - A.plataHombre.getCantidad());
				if (output == 0) {
					output = (int) (B.bronceHombre.getCantidad() - A.bronceHombre.getCantidad());
					if (output == 0) {
						output = B.nombre.compareTo(A.nombre);
					}
				}
			}

		} else if (orden.equals("2")) {
			output = (int) (A.oroMujer.getCantidad() - B.oroMujer.getCantidad());
			if (output == 0) {
				output = (int) (A.plataMujer.getCantidad() - B.plataMujer.getCantidad());
				if (output == 0) {
					output = (int) (A.bronceMujer.getCantidad() - B.bronceMujer.getCantidad());
					if (output == 0) {
						output = A.nombre.compareTo(B.nombre);
						output *= -1;
					}
				}
			}

		} else {
			output = (int) B.calcularMedallasDeOro() - A.calcularMedallasDeOro();
			if (output == 0) {

				output = (int) B.calcularMedallasDePlata() - A.calcularMedallasDePlata();
				if (output == 0) {

					output = (int) B.calcularMedallasDeBronce() - A.calcularMedallasDeBronce();
					;
					if (output == 0) {

						output = (B.nombre.compareTo(A.nombre));
					}
				}
			}
		}

		return output;
	}

	public String toString() {

		String out = "";
		if (orden.equals("1")) {

			out += nombre + " " + oroHombre.getCantidad() + " " + plataHombre.getCantidad() + " "
					+ bronceHombre.getCantidad();

		} else if (orden.equals("2")) {

			out += nombre + " " + oroMujer.getCantidad() + " " + plataMujer.getCantidad() + " "
					+ bronceMujer.getCantidad();

		} else {

			int oros = calcularMedallasDeOro();
			int platas = calcularMedallasDePlata();
			int bronces = calcularMedallasDeBronce();
			out += nombre + " " + oros + " " + platas + " " + bronces;
		}

		return out;
	}

}