// Avtor: Maks Štempihar

// Deklariramo javni razred
public class Televizor{
	
	// Deklariramo lastnosti
	// primitivni podatkovni tipi		
	private int stevilkaPrograma;
	private int zvok;
	protected double temperatura;		// v stopinjah celzija
	private boolean vklopljenTv;
	// deklariramo objekt z imenom vsebina razreda string
	private String diagonala;
	
	// deklariramo javni konstruktor
	// ustvarimo Televizor z lastnostmi
	// parametri: Številka Programa, zvok, diagonala, vir
	// vrača: nov objekt razreda Televizor
	public Televizor(int sp, int z, String d, double tempe){
		
		// inicializiramo lastnosti
		stevilkaPrograma = sp;
		zvok = z;
		vklopljenTv = false;
		diagonala = d;
		temperatura = tempe;
		
		
		// izpišemo konzolo dogodek
		System.out.println("Ustvarjam televizor z diadonalo" + diagonala + ", nastavljen na program " + stevilkaPrograma + " ter volumnom " + zvok);
	}
	
	public Televizor(int sp, int z, String d){
		
		// inicializiramo lastnosti
		stevilkaPrograma = sp;
		zvok = z;
		vklopljenTv = false;
		diagonala = d;
		
		
		// izpišemo konzolo dogodek
		System.out.println("Ustvarjam televizor z diadonalo" + diagonala + ", nastavljen na program " + stevilkaPrograma + " ter volumnom " + zvok);
	}
	
	// deklariramo metodo, ki zmanjša količino steklenice
	// parametri: jih ni
	// vrača: uspešnost vklopa TV
	public boolean priklopTv(){
		
		// če je Tv izklopljen
		if(vklopljenTv){
			System.out.println("TV je že priklopljen!");
			return false;
		}
		// če je že priklopljen
		else{
			System.out.println("vklop TV-ja");
			vklopljenTv = true;
			return true;
		}
	}
	
	// deklariramo metodo, ki premakne program naprej
	// parametri: Število za kolliko programov želimo premakniti naprej
	// vrača: Novo številko programa
	public String programNaprej(String sp) throws Exception{
		
		// če je Tv priklopljen
		if(vklopljenTv){
			
			int spn = 0;
			
			try{
				spn = Integer.parseInt(sp);
			}
		
			// če metoda parseInt vrže izjemo 
			catch(Exception e){
			
				// izpišemo napako in vržemo izjemo nazaj
				System.out.println("Napaka pri pretvorbi:" + e.toString());
				throw new Exception(spn + " Ni število!");
			}
			
			for(int c=0; c<spn; c++){
				stevilkaPrograma += 1;
			}
			
			// če je glasnost pod maksimalno vrednostjo
			if(stevilkaPrograma <= 250){
				// Izpiše novo številko programa
				System.out.println("Povečamo program na " + stevilkaPrograma);
				throw new Exception("Program ne obstaja!");
			}
		}
		
		// če Tv izklopljen
		else{
			System.out.println("Televizor je ugasnjen!");
		}
		return sp;
	}

	// deklariramo metodo, ki premakne program nazaj
	// parametri: Število za kolliko programov želimo premakniti nazaj
	// vrača: Novo številko programa
	public String programNazaj(String sp) throws Exception{
		
		// če je Tv priklopljen
		if(vklopljenTv){
			
			int spn = 0;
			
			try{
				spn = Integer.parseInt(sp);
			}
		
			// če metoda parseInt vrže izjemo 
			catch(Exception e){
			
				// izpišemo napako in vržemo izjemo nazaj
				System.out.println("Napaka pri pretvorbi:" + e.toString());
				throw new Exception(spn + " Ni število!");
			}
			
			for(int c=0; c<spn; c++){
				stevilkaPrograma -= 1;
			}
			
			// če je glasnost pod maksimalno vrednostjo
			if(1 <= stevilkaPrograma){
				// Izpiše novo številko programa
				System.out.println("Zmanjšamo program na " + stevilkaPrograma);
				throw new Exception("Program ne obstaja!");
			}
		}
		// če je Tv izklopljen
		else{
			System.out.println("Televizor je ugasnjen!");
		}
		return sp;
	}
	
	// deklariramo metodo, ki poveča glasnost
	// parametri: Število za kolliko želimo povečati glasnost
	// vrača: novo vrednost glasnosti
	public String povisanjeZvoka(String z)throws Exception{
		
		// če je TV priklopljen
		if(vklopljenTv){
			
			int zv = 0;
			
			try{
				zv = Integer.parseInt(z);
			}
		
			// če metoda parseInt vrže izjemo 
			catch(Exception e){
			
				// izpišemo napako in vržemo izjemo nazaj
				System.out.println("Napaka pri pretvorbi:" + e.toString());
				throw new Exception(zv + " Ni število!");
			}
			
			for(int c=0; c<zv; c++){
				zvok += 1;
			}
			
			// če je glasnost pod maksimalno vrednostjo
			if(zvok <= 99){
				// izpišemo novo glasnost
				System.out.println("Glasnost zmanjšamo na " + zvok);
				throw new Exception("Dosežena maksimalna glasnost!");
			}
		}
		// če je TV izklopljen
		else{
			System.out.println("Televizor je ugasnjen!");
		}
		return z;
	}
	
	// deklariramo metodo, ki poveča glasnost
	// parametri: Število za kolliko želimo povečati glasnost
	// vrača: novo vrednost glasnosti
	public String znizanjeZvoka(String z) throws Exception{
		
		// če je TV priklopljen
		if(vklopljenTv){
			
			int zv = 0;
			
			try{
				zv = Integer.parseInt(z);
			}
		
			// če metoda parseInt vrže izjemo 
			catch(Exception e){
			
				// izpišemo napako in vržemo izjemo nazaj
				System.out.println("Napaka pri pretvorbi:" + e.toString());
				throw new Exception(zv + " Ni število!");
			}
			
			for(int c=0; c<zv; c++){
				zvok -= 1;
			}
			
			// če je glasnost nad minimalno vrednostjo
			if(0 < zvok){
				// izpišemo novo glasnost
				System.out.println("Glasnost zmanjšamo na " + zvok);
				throw new Exception("Tišina!");
			}
		}
		//če je TV izklopljen
		else{
			System.out.println("Televizor je ugasnjen!");
		}
		return z;
	}
	
	// getter metoda, ki vrne številko programa
	public int getProgram(){
		return stevilkaPrograma;
	}
	
	// getter metoda, ki vrne glasnost
	public int getGlasnost(){
		return zvok;
	}
	
	// getter metoda, ki vrne diadonalo
	public String getDiagonala(){
		return diagonala;
	}
}