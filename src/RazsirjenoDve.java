// deklariramo javni razred RazsirjenoDve, ki razširja razred Televizor(od nje podeduje vse lastnosti in metode)
public class RazsirjenoDve extends Televizor{
	
	// vse lastnosti, ki jih imajo ostale televizije
	private int poljubniProgram;
	
	// konstruktor
	// vhodi: poljubni program
	// vrne: nov objekt tipa RazsirjenoDve
	public RazsirjenoDve(int sp, int z, String d, int p){
		
		// pokličemo konstruktor razreda
		super(sp, z, d);
		
		// inicializiramo dodatne lastnosti
		poljubniProgram = p;
	}
	
	//konstruktor, ki ustvari pivsko steklenico v kateri ni piva
	public RazsirjenoDve(int sp, int z, String d){
		
		// pokličemo konstruktor razreda
		super(sp, z, d);
	
		// inicializiramo dodatne lastnosti
		poljubniProgram = 0;
	}
	
	// metoda premakne program naprej na željeni program
	// vhod: int z programom ki ga želimo
	// izhod: željeni program
	public void prestaviNazaj(String p) throws Exception{
		
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
		
		// če bi presegli 999 programov, ki jih lahko sharni televizor
		if(getProgram() - (getProgram() - stp) <= 0){
			poljubniProgram = getProgram();
			throw new Exception("Programa ne moremo premakniti, ker ta ševilka ne obstaja!");
		}
		
		poljubniProgram = getProgram() - (getProgram() - stp);
	
		System.out.println("Premaknemo naprej na željeni program " + poljubniProgram);
	
	}
}