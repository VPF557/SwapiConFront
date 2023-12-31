package SwapiConFront.example.SwapiConFront;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SpringBootTest
class SwapiConFrontApplicationTests {

	@Test
	void contextLoads() {
	}
	@org.junit.Test
	public void buscarObjeto()
	{
		//Comprobamos si un objeto se ha borrado correctamente
		Param param = new Param("planets" , 5);
		LeerJson reader = new LeerJson();
		ArrayList<Param> listaORG = new ArrayList<Param>();
		ArrayList<Param>  listaNuev = reader.LeerFicheroPeticiones("Petitions.json") ;
		DataHanding data = new DataHanding();
		listaNuev = data.buscarObjeto(param.getParameter1(),param.getParameter2(),"Petitions.json");

		if(listaNuev.size() == listaORG.size())
		{
			fail("No lo ha borrado correctamente");
		}
		{
			assertTrue(true);
		}

	}
}
