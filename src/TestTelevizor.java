// Avtor: Maks Štempihar

// vključimo paket za delo z vhodno/izhodnimi napravami
import java.io.*;

// vključimo paket za delo s pripomočki
import java.util.*;

// Deklariramo javni razred
public class TestTelevizor{
	
	// deklariramo zasebno lastnost za vnoss iz konzole
	private static  BufferedReader in;
	
	// deklariramo zasebno statično lastnost seznama televizorji
	private static ArrayList<RazsirjenoEna> televizorji;
	
	// Deklariramo javno statično metodo main
	// Prejme:
	// Vrne: /
	public static void main(String[] args){
		
		// inicializiramo seznam televizorji
		televizorji = new ArrayList<RazsirjenoEna>();
		
		// inicializiramo objekt in 
		in = new BufferedReader(new InputStreamReader(System.in));
		
		// Ustvarimo objekt (ga deklariramo in inicializiramo) tipa Televizor
		RazsirjenoEna maliTelevizor = new RazsirjenoEna(50, 33, "95cm", 70.7);
		RazsirjenoEna srednjiTelevizor = new RazsirjenoEna(245, 80, "100cm", 50.0);
		RazsirjenoEna velikiTelevizor = new RazsirjenoEna(67, 47, "105cm", 50.6);
		RazsirjenoEna razsirjeniTelevizor = new RazsirjenoEna(34, 22, "120cm", 35.8);
		RazsirjenoDve razsirjeniDveTelevizor = new RazsirjenoDve(105, 87, "90cm");
		
		// obstoječe objekte dodamo na seznam
		televizorji.add(maliTelevizor);
		televizorji.add(srednjiTelevizor);
		televizorji.add(velikiTelevizor);
		televizorji.add(razsirjeniTelevizor);
		
		// dodamo na seznam še en televizor iz praznega poziva
		System.out.println("== DODAJ TELEVIZOR ==");
		while(true){
			try{
				System.out.print("Diagonala:");
				String d = in.readLine();
				
				if(d.trim().isEmpty()){
					break;
				}
				
				System.out.print("Številka programa:");
				int pr = Integer.parseInt(in.readLine());
				
				System.out.print("Glasnost:");
				int g = Integer.parseInt(in.readLine());
				
				System.out.print("Temperatura:");
				double temp = Double.parseDouble(in.readLine());
				
				televizorji.add(new RazsirjenoEna(pr, g, d,temp));
			}
			catch(Exception e){
				// napaka pri vnosu ali pretvorbi.
				System.out.println("Napaka pri dodajanju: " + e.toString());
				break;
			}
			System.out.println("======================");
		}
		
		// izpišemo celoten seznam televizorev
		for(int c=0; c<televizorji.size(); c++){
			System.out.println(televizorji.get(c).getNalepka());
			
			// izpišemo čisti alkohol
			double te = 0.0 + televizorji.get(c).getTemperatura();
			if(te <= 50.0){
				System.out.println("Temperatura televizije je: " + te + " stopinj celzija.");
			}
			else{
				System.out.println("Televizija se pregreva");
			}
			
		}
		
		// inicializiramo in deklariramo objekte
		String programNaprej = "0";
		String programNazaj = "0";
		String povisanjeZvoka = "0";
		String znizanjeZvoka = "0";
		String pNaprej = "0";
		String prestaviNazaj = "0";
		
		
		
		// velika Televizija
		
		// priklopimo televizor
		velikiTelevizor.priklopTv();
		
		// Skušamo vprašati uporabnika za koliko naj ogrejemo pivo premaknemo program naprej
		try{
			System.out.print("Koliko naj premaknemo program naprej? ");
			
			// priredimo vrednost objektu
			programNaprej = in.readLine();
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			programNaprej = "NAPAKA!";
			System.out.print("Prišlo je do napake pri vnosu številke za premikanje programa: " + e.toString());
		}
		
		// veliki televizor premik programov
		try{
			System.out.println("Program premaknemo za " + programNaprej + " kanalov.");
			velikiTelevizor.programNaprej(programNaprej);
		}
		
		catch(Exception e){
			System.out.println("Ujeta izjema:" + e.toString());
		}
		
		// zmanjšamo zvok
		try{
			System.out.print("Koliko naj znižamo zvok? ");
			
			// priredimo vrednost objektu
			znizanjeZvoka = in.readLine();
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			znizanjeZvoka = "NAPAKA!";
			System.out.print("Prišlo je do napake pri znižanju Zvoka: " + e.toString());
		}
		
		// veliki televizor sprememba zvoka
		try{
			System.out.println("Zvok znižamo za " + znizanjeZvoka);
			velikiTelevizor.znizanjeZvoka(znizanjeZvoka);
		}
		
		catch(Exception e){
			System.out.println("Ujeta izjema:" + e.toString());
		}
		
		// premaknemo program nazaj
		try{
			System.out.print("Koliko naj premaknemo program nazaj? ");
			
			// priredimo vrednost objektu
			programNazaj = in.readLine();
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			programNazaj = "NAPAKA!";
			System.out.print("Prišlo je do napake pri vnosu številke za premikanje programa: " + e.toString());
		}
		
		// veliki televizor premik programov
		try{
			System.out.println("Program premaknemo za " + programNazaj + " kanalov.");
			velikiTelevizor.programNazaj(programNazaj);
		}
		
		catch(Exception e){
			System.out.println("Ujeta izjema:" + e.toString());
		}
		
		// povečamo zvok
		try{
			System.out.print("Koliko naj povečamo zvok? ");
			
			// priredimo vrednost objektu
			povisanjeZvoka = in.readLine();
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			povisanjeZvoka = "NAPAKA!";
			System.out.print("Prišlo je do napake pri povičanju Zvoka: " + e.toString());
		}
		
		// veliki televizor sprememba zvoka
		try{
			System.out.println("Zvok znižamo za " + povisanjeZvoka);
			velikiTelevizor.povisanjeZvoka(povisanjeZvoka);
		}
		
		catch(Exception e){
			System.out.println("Ujeta izjema:" + e.toString());
		}
		
		// MALA TELEVIZIJA
		
		// priklopimo televizor
		maliTelevizor.priklopTv();
	
		// Skušamo vprašati uporabnika za koliko naj premaknemo program
		try{
			System.out.print("Koliko naj premaknemo program naprej? ");
			
			// priredimo vrednost objektu
			programNaprej = in.readLine();
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			programNaprej = "NAPAKA!";
			System.out.print("Prišlo je do napake pri vnosu številke za premikanje programa: " + e.toString());
		}
		
		// mali televizor premik programov
		try{
			System.out.println("Program premaknemo za " + programNaprej + " kanalov.");
			maliTelevizor.programNaprej(programNaprej);
		}
		
		catch(Exception e){
			System.out.println("Ujeta izjema:" + e.toString());
		}
		
		// zmanjšamo zvok
		try{
			System.out.print("Koliko naj znižamo zvok? ");
			
			// priredimo vrednost objektu
			znizanjeZvoka = in.readLine();
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			znizanjeZvoka = "NAPAKA!";
			System.out.print("Prišlo je do napake pri znižanju Zvoka: " + e.toString());
		}
		
		// mali televizor sprememba zvoka
		try{
			System.out.println("Zvok znižamo za " + znizanjeZvoka);
			maliTelevizor.znizanjeZvoka(znizanjeZvoka);
		}
		
		catch(Exception e){
			System.out.println("Ujeta izjema:" + e.toString());
		}
		
		// SREDNJA TELEVIZIJA
		
		// priklopimo televizor
		srednjiTelevizor.priklopTv();
		
		// premaknemo program nazaj
		try{
			System.out.print("Koliko naj premaknemo program nazaj? ");
			
			// priredimo vrednost objektu
			programNazaj = in.readLine();
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			programNazaj = "NAPAKA!";
			System.out.print("Prišlo je do napake pri vnosu številke za premikanje programa: " + e.toString());
		}
		
		// srednji televizor premik programov
		try{
			System.out.println("Program premaknemo za " + programNazaj + " kanalov.");
			srednjiTelevizor.programNazaj(programNazaj);
		}
		
		catch(Exception e){
			System.out.println("Ujeta izjema:" + e.toString());
		}
		
		// povečamo zvok
		try{
			System.out.print("Koliko naj povečamo zvok? ");
			
			// priredimo vrednost objektu
			povisanjeZvoka = in.readLine();
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			povisanjeZvoka = "NAPAKA!";
			System.out.print("Prišlo je do napake pri povičanju Zvoka: " + e.toString());
		}
		
		// srednji televizor sprememba zvoka
		try{
			System.out.println("Zvok znižamo za " + povisanjeZvoka);
			srednjiTelevizor.povisanjeZvoka(povisanjeZvoka);
		}
		
		catch(Exception e){
			System.out.println("Ujeta izjema:" + e.toString());
		}
		
		// RAZŠIRJENA TELEVIZIJA 
		
		// priklopimo televizor
		razsirjeniTelevizor.priklopTv();
		
		// premaknemo na željeni program
		try{
			System.out.print("Na kateri program naprej želite premakniti? ");
			
			// priredimo vrednost objektu
			pNaprej = in.readLine();
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			pNaprej = "NAPAKA!";
			System.out.print("Prišlo je do napake pri premikanju programa: " + e.toString());
		}
	
		// razsirjeni televizor premik programov
		try{
			System.out.println("Program premaknemo na " + pNaprej + " kanal.");
			razsirjeniTelevizor.prestaviNaprej(pNaprej);
		}
		
		catch(Exception e){
			System.out.println("Ujeta izjema:" + e.toString());
		}
		// RAZŠIRJENA TELEVIZIJA DVE
		
		// priklopimo televizor
		razsirjeniDveTelevizor.priklopTv();
		
		// premaknemo na željeni program
		try{
			System.out.print("Na kateri program nazaj želite premakniti? ");
			
			// priredimo vrednost objektu
			prestaviNazaj = in.readLine();
		}
		// če je prišlo do napake pri vnosu
		catch(Exception e){
			prestaviNazaj = "NAPAKA!";
			System.out.print("Prišlo je do napake pri premikanju programa: " + e.toString());
		}
		
		// razsirjeni televizor dve premik programov
		try{
			System.out.println("Program premaknemo na " + prestaviNazaj + " kanal.");
			razsirjeniDveTelevizor.prestaviNazaj(prestaviNazaj);
		}
		
		catch(Exception e){
			System.out.println("Ujeta izjema:" + e.toString());
		}
	}	
}