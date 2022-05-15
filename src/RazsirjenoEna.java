// deklariramo javni razred RazsirjenoEna, ki razširja razred Televizor(od nje podeduje vse lastnosti in metode)
public class RazsirjenoEna extends Televizor implements Temperatura{
	
	// vse lastnosti, ki jih imajo ostale televizije
	private int poljubniProgram;
	
	// konstruktor
	// vhodi: poljubni program
	// vrne: nov objekt tipa RazsirjenoEna
	public RazsirjenoEna(int sp, int z, String d, double tem, int p){
		
		// pokličemo konstruktor razreda
		super(sp, z, d, tem);
		
		// inicializiramo dodatne lastnosti
		poljubniProgram = p;
	}
	
	//konstruktor, ki ustvari pivsko steklenico v kateri ni piva
	public RazsirjenoEna(int sp, int z, String d, double tem){
		
		// pokličemo konstruktor razreda
		super(sp, z, d, tem);
	
		// inicializiramo dodatne lastnosti
		poljubniProgram = 0;
	}
	
	// metoda premakne program naprej na željeni program
	// vhod: int z programom ki ga želimo
	// izhod: željeni program
	public void prestaviNaprej(String p)throws Exception{
		
		int stp = 0; 
		
		// pretorim niz v int
		try{
			stp = Integer.parseInt(p);
		}
		
		// če metoda parseInt vrže izjemo 
		catch(Exception e){
			
			// izpišemo napako in vržemo izjemo nazaj
			System.out.println("Napaka pri pretvorbi:" + e.toString());
			throw new Exception(stp + " Ni število!");
		}
		
		// če bi program presegel število programov, ki jih sprejema oz. gre preko 250 programov, ki jih lahko uporabnik gleda
		if((stp - getProgram()) + getProgram() >= 250){
			poljubniProgram = (stp - getProgram()) + getProgram();
			throw new Exception("Program ne obstaja!");
		}
		
		// če bi presegli 999 programov, ki jih lahko sharni televizor
		if((stp - getProgram()) + getProgram() >= 999){
			poljubniProgram = getProgram();
			throw new Exception("Programa ne moremo premakniti, ker ta ševilka ne obstaja!");
		}
		
		poljubniProgram = (stp - getProgram()) + getProgram();
	
		System.out.println("Premaknemo naprej na željeni program " + poljubniProgram);
	
	}
	
	// metoda vrne vsebino nalepke
	// vhod: /
	// vrne: podatki na nalepki
	public String getNalepka(){
		String ret = " === TELEVIZOR === \n";
		ret += " Program: " + getProgram() + "\n";
		ret += " Glasnost: " + getGlasnost() + "\n";
		ret += " Diagonala: " + getDiagonala() + "\n";
		ret += " Temperatura: " + temperatura + " stopinj celzija. \n";
		ret += "============\n";
		return ret;
	}
	
	// getter metoda, ki vrne temparaturo
	public double getTemperatura(){
		return temperatura;
	}
}