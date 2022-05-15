// Avtor: Maks Štempihar

// uvozimo paket za delo s tabelami
import javax.swing.table.*;

// uvozimo paket za delo s pripomočki
import java.util.*;

// javni razred za model tabele
public class TelevizorTableModel extends DefaultTableModel{
	
	// Deklariramo lastnosti
	private ArrayList<RazsirjenoEna>televizorji;
	
	// konstruktor
	public TelevizorTableModel(){
		
		// kličemo konstruktor nadrazreda
		super();
		
		// inicializiramo lastnosti
		televizorji = new ArrayList<RazsirjenoEna>();
		
		// dodamo stolpce
		addColumn("Program");
		addColumn("Glasnost");
		addColumn("Diagonala");
		addColumn("Temperatura");
	}
	
	// Metoda, ki doda pivsko steklenico v model tabele
	public void addRazsirjenoEna(RazsirjenoEna ps){
		
		// Dodamo objekt v argumentu na seznam
		televizorji.add(ps);
		
		// ustavrimoseznam objektov za vrstico v tabeli 
		Object[] vrstica = new Object[]{ps.getProgram(), ps.getGlasnost(), ps.getDiagonala(),ps.getTemperatura()};
		
		// dodamo vrstico v tabelo
		addRow(vrstica);
		
	}
}