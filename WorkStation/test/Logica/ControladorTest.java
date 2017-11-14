/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ControladorTest {
    
    public ControladorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registrarCliente method, of class Controlador.
     */
    @Test
    public void testRegistrarCliente() {
        System.out.println("registrarCliente");
        String nickname = "ClienteTest";
        String contraseña = "ClienteTest";
        String mail = "ClienteTest";
        String nombre = "ClienteTest";
        String apellido = "ClienteTest";
        Fecha fechaDeNacimiento = new Fecha(1,1,1);
        String imagen = "";
        Controlador instance = new Controlador();
        List L = new ArrayList();
        L.addAll(instance.getItemCliente());
        int pre = L.size()+1;//+1 es por el nuevo creado
        instance.registrarCliente(nickname, contraseña, mail, nombre, apellido, fechaDeNacimiento, imagen);
        List L2 = new ArrayList();
        L2.addAll(instance.getItemCliente());
        int pos = L2.size();
        assertEquals(pre,pos);
    }

    /**
     * Test of registrarArtista method, of class Controlador.
     */
    @Test
    public void testRegistrarArtista() {
        System.out.println("registrarArtista");
        String nickname = "ArtTest";
        String contraseña = "ArtTest";
        String mail = "ArtTest";
        String nombre = "ARtTest";
        String apellido = "ARtTest";
        Fecha fechaDeNacimiento = new Fecha(1,1,1);
        String imagen = "";
        String biografia = "ArtTest";
        String dir_web = "ArtTest";
        Controlador instance = new Controlador();
        List L = new ArrayList();
        L.addAll(instance.getItemArtist());
        int pre = L.size()+1;//+1 es por el nuevo creado
        instance.registrarArtista(nickname, contraseña, mail, nombre, apellido, fechaDeNacimiento, imagen, biografia, dir_web);
        List L2 = new ArrayList();
        L2.addAll(instance.getItemArtist());
        int pos = L2.size();
        assertEquals(pre,pos);
    }

    /**
     * Test of getListaClientes method, of class Controlador.
     */
    @Test
    public void testGetListaClientes() {
        System.out.println("getListaClientes");
        Controlador instance = new Controlador();
        int cantExpetc = 5;
        List<Cliente> result = instance.getListaClientes();
        int cantResult = result.size();
        assertEquals(cantExpetc, cantResult);
    }
//
//    /**
//     * Test of AltaGenero method, of class Controlador.
//     */
    @Test
    public void testAltaGenero() {
        System.out.println("AltaGenero1");
        String nombre = "TestGenero";
        String padre = "";
        Controlador instance = new Controlador();
        instance.AltaGenero(nombre, padre);
        List result = instance.getGeneroItem();
        int cantExpect = result.size() +1;
        int cantResult = cantExpect;
        assertEquals(cantExpect, cantResult);
    }
    
    @Test
    public void testAltaGenero2() {
        System.out.println("AltaGenero2");
        String nombre = "TestGenero";
        String padre = "";
        Controlador instance = new Controlador();
        instance.AltaGenero(nombre, padre);
        List result = instance.getGeneroItem();
        int cantExpect = result.size();
        int cantResult = cantExpect;
        assertEquals(cantExpect, cantResult);
    }
    
    @Test
    public void testAltaGenero3() {
        System.out.println("AltaGenero3");
        String nombre = "TestGenero2";
        String padre = "TestGenero";
        Controlador instance = new Controlador();
        instance.AltaGenero(nombre, padre);
        List result = instance.getGeneroItem();
        int cantExpect = result.size() +1;
        int cantResult = cantExpect;
        assertEquals(cantExpect, cantResult);
    }
    
        @Test
    public void testAltaGenero4() {
        System.out.println("AltaGenero4");
        String nombre = "TestGenero3";
        String padre = "General";
        Controlador instance = new Controlador();
        instance.AltaGenero(nombre, padre);
        List result = instance.getGeneroItem();
        int cantExpect = result.size() +1;
        int cantResult = cantExpect;
        assertEquals(cantExpect, cantResult);
    }
    
    @Test
    public void testAltaGenero5() {
        System.out.println("AltaGenero5");
        String nombre = "";
        String padre = "";
        Controlador instance = new Controlador();
        instance.AltaGenero(nombre, padre);
        List result = instance.getGeneroItem();
        int cantExpect = result.size();
        int cantResult = cantExpect;
        assertEquals(cantExpect, cantResult);
    }
    
//    @Test
//    public void testAltaGenero6() {
//        System.out.println("AltaGenero6");
//        String nombre = "TestGenero454545";
//        String padre = "generoFalso";
//        Controlador instance = new Controlador();
//        instance.AltaGenero(nombre, padre);
//        List result = instance.getGeneroItem();
//        int cantExpect = result.size();
//        int cantResult = cantExpect;
//        assertEquals(cantExpect, cantResult);
//    }
    
//    @Test
//    public void testAltaGenero7() {
//        System.out.println("AltaGenero7");
//        String nombre = "General";
//        String padre = "";
//        Controlador instance = new Controlador();
//        instance.AltaGenero(nombre, padre);
//        List result = instance.getGeneroItem();
//        int cantExpect = result.size();
//        int cantResult = cantExpect;
//        assertEquals(cantExpect, cantResult);
//    }

//
//    /**
//     * Test of GetGenero method, of class Controlador.
//     */
    @Test
    public void testGetGenero() {
        System.out.println("GetGenero");
        Controlador instance = new Controlador();
        String expResult = "General";
        Genero g = instance.GetGenero();
        String result = g.getNombre();
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of getGeneroPorNombre method, of class Controlador.
//     */
    @Test
    public void testGetGeneroPorNombre() {
        System.out.println("getGeneroPorNombre");
        String nombre = "TestGenero";
        Controlador instance = new Controlador();
        Genero result = instance.getGeneroPorNombre(nombre);
        assertEquals(nombre, result.getNombre());
    }
    
    @Test
    public void testGetGeneroPorNombre2() {
        System.out.println("getGeneroPorNombre");
        String nombre = "GeneroFalso";
        Controlador instance = new Controlador();
        Genero result = instance.getGeneroPorNombre(nombre);
        assertEquals(null, result);
    }
//
//    /**
//     * Test of ConsultarAlbum method, of class Controlador.
//     */
//    @Test
//    public void testConsultarAlbum() {
//        System.out.println("ConsultarAlbum");
//        Controlador instance = new Controlador();
//        instance.ConsultarAlbum();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of FindUser method, of class Controlador.
//     */
//    @Test
//    public void testFindUser() {
//        System.out.println("FindUser");
//        String nickname = "TestFindUser";
//        String contraseña = "TestFindUser";
//        String mail = "TestFindUser";
//        String nombre = "TestFindUser";
//        String apellido = "TestFindUser";
//        Fecha fechaDeNacimiento = new Fecha(1,1,1);
//        String imagen = "";
//        Controlador instance = new Controlador();
//        instance.registrarCliente(nickname, contraseña, mail, nombre, apellido, fechaDeNacimiento, imagen);
//        boolean expResult = true;
//        String text = "TestFindUser";
//        boolean result = instance.FindUser(text);
//        assertEquals(expResult, result);
//    }
    
//    @Test
//    public void testFindUser2() {
//        System.out.println("FindUser2");
//        String text = "FalseClient";
//        Controlador instance = new Controlador();
//        boolean expResult = false;
//        boolean result = instance.FindUser(text);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of SeguirUsuario method, of class Controlador.
//     */
//    @Test
//    public void testSeguirUsuario_Item_Item() {
//        System.out.println("SeguirUsuario");
//        Item seguidor = null;
//        Item seguido = null;
//        Controlador instance = new Controlador();
//        instance.SeguirUsuario(seguidor, seguido);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of nicknameLibre method, of class Controlador.
//     */
//    @Test
//    public void testNicknameLibre() {
//        System.out.println("nicknameLibre");
//        String nickname = "";
//        Controlador instance = new Controlador();
//        boolean expResult = false;
//        boolean result = instance.nicknameLibre(nickname);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
//    @Test
//    public void testGetListaClientes2() {
//        System.out.println("getListaClientes_Agregar2ychequar");
//        Controlador instance = new Controlador();
//        
//         List<Cliente> list = Arrays.asList(
//                new Cliente("Client1", "pass", "Client1@mail", "ClientName", "ClientSurname", new Fecha(11,11,11), "imagePath"),
//                new Cliente("Client2", "pass", "Client2@mail", "Client2Name", "Client2Surname", new Fecha(20,11,11), "imagePath")
//         );
//        
//        int cantExpetc = 2;
//       // List<Cliente> result = instance.getListaClientes();
//        int cantResult = list.size();
//        
//        //Test equals
//        assertThat(list, hasItems(
//                new Cliente("Client1", "pass", "Client1@mail", "ClientName", "ClientSurname", new Fecha(11,11,11), "imagePath"),
//                new Cliente("Client2", "pass", "Client2@mail", "Client2Name", "Client2Surname", new Fecha(20,11,11), "imagePath"))
//        );
//        //Test size
//        assertEquals(cantExpetc, cantResult);
//    }
    
    
//
//    /**
//     * Test of mailLibre method, of class Controlador.
//     */
    @Test
    public void testMailLibre1() {
        System.out.println("mailLibre1_mailNoEstaLibre");        
        String mail = "kek";
        Controlador instance = new Controlador();
        boolean expResult = false;
        
        instance.registrarCliente("", "", "kek", "", "", null, "");        
        boolean result = instance.mailLibre(mail);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMailLibre2() {
        System.out.println("mailLibre1_mailEstaLibre");        
        String mail = "kek1";
        Controlador instance = new Controlador();
        boolean expResult = true;    
        boolean result = instance.mailLibre(mail);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of consultarCliente method, of class Controlador.
//     */
    @Test
    public void testConsultarCliente1() {
        System.out.println("consultarCliente1_clienteExiste");
        String nickname = "The boy";
        Controlador instance = new Controlador();
        instance.registrarCliente("The boy", "pass", "The boyMail", "asd", "asd", new Fecha(1,1,1), "path");    
        Cliente expResult = new Cliente("The boy", "pass", "The boyMail", "asd", "asd", new Fecha(1,1,1), "path");
        Cliente result = instance.consultarCliente(nickname);
        boolean equals = expResult instanceof Cliente && result.equals(expResult);
        assertEquals(true, equals);
    }
    
    @Test
    public void testConsultarCliente2() {
        System.out.println("consultarCliente1_clienteNoExiste");
        String nickname = "The boy";
        Controlador instance = new Controlador();  
        Cliente expResult = new Cliente("The boy2", "pass", "The boyMail", "asd", "asd", new Fecha(1,1,1), "path");
        Cliente result = instance.consultarCliente(nickname);
        boolean equals = expResult instanceof Cliente && result.equals(expResult);
        assertEquals(false, equals);
    }

//    /**
//     * Test of consultarArtista method, of class Controlador.
//     */
    @Test
    public void testConsultarArtista1() {
        System.out.println("consultarArtista1_artistaExiste");
        String nickname = "The boy3";
        Controlador instance = new Controlador();
        Artista expResult = new Artista("bio", "dir", nickname, "pass", "The boyMail", "asd", "asd", new Fecha(1,1,1), "path");
        instance.registrarArtista(nickname, "pass", "The boyMail", "asd", "asd" , new Fecha(1,1,1), "path", "bio" , "dir");
        Artista result = instance.consultarArtista(nickname);
        boolean equals = expResult instanceof Artista && result.equals(expResult);
        assertEquals(equals, true);
        
            
        
    }
//
//    /**
//     * Test of getItemCliente method, of class Controlador.
//     */
//    @Test
//    public void testGetItemCliente() {
//        System.out.println("getItemCliente");
//        Controlador instance = new Controlador();
//        List expResult = null;
//        List result = instance.getItemCliente();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getItemArtista method, of class Controlador.
//     */
//    @Test
//    public void testGetItemArtista() {
//        System.out.println("getItemArtista");
//        Controlador instance = new Controlador();
//        List expResult = null;
//        List result = instance.getItemArtista();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTemasItem method, of class Controlador.
//     */
//    @Test
//    public void testGetTemasItem() {
//        System.out.println("getTemasItem");
//        Controlador instance = new Controlador();
//        List expResult = null;
//        List result = instance.getTemasItem();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getGeneroItem method, of class Controlador.
//     */
//    @Test
//    public void testGetGeneroItem() {
//        System.out.println("getGeneroItem");
//        Controlador instance = new Controlador();
//        List expResult = null;
//        List result = instance.getGeneroItem();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of agregarTemaALista method, of class Controlador.
//     */
//    @Test
//    public void testAgregarTemaALista() {
//        System.out.println("agregarTemaALista");
//        Object Lista = null;
//        Object Tema = null;
//        Controlador instance = new Controlador();
//        instance.agregarTemaALista(Lista, Tema);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of QuitarTemaFavorito method, of class Controlador.
//     */
//    @Test
//    public void testQuitarTemaFavorito_Item_Item() {
//        System.out.println("QuitarTemaFavorito");
//        Item cliente = null;
//        Item tema = null;
//        Controlador instance = new Controlador();
//        instance.QuitarTemaFavorito(cliente, tema);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of QuitarAlbumFav method, of class Controlador.
//     */
//    @Test
//    public void testQuitarAlbumFav_Item_Item() {
//        System.out.println("QuitarAlbumFav");
//        Item cliente = null;
//        Item album = null;
//        Controlador instance = new Controlador();
//        instance.QuitarAlbumFav(cliente, album);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of QuitarListaFav method, of class Controlador.
//     */
//    @Test
//    public void testQuitarListaFav_Item_Item() {
//        System.out.println("QuitarListaFav");
//        Item cliente = null;
//        Item lista = null;
//        Controlador instance = new Controlador();
//        instance.QuitarListaFav(cliente, lista);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAlbumPorGenItem method, of class Controlador.
//     */
//    @Test
//    public void testGetAlbumPorGenItem() {
//        System.out.println("getAlbumPorGenItem");
//        String s = "";
//        Controlador instance = new Controlador();
//        List expResult = null;
//        List result = instance.getAlbumPorGenItem(s);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getItemArtist method, of class Controlador.
//     */
//    @Test
//    public void testGetItemArtist() {
//        System.out.println("getItemArtist");
//        Controlador instance = new Controlador();
//        List expResult = null;
//        List result = instance.getItemArtist();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addListaParticular method, of class Controlador.
//     */
    @Test
    public void testAddListaParticular1() {
        System.out.println("addListaParticular1_clienteNull");
        Cliente client = null;
        String nombreDeLista = "";
        String imagenDeLista = "";
        Controlador instance = new Controlador();
        instance.addListaParticular(client, nombreDeLista, imagenDeLista);
    }
    
    @Test
    public void testAddListaParticular2() {
        System.out.println("addListaParticular2_agregarCliente");
        Cliente client = new Cliente("The boy4", "pass", "The boyMail4", "asd", "asd", new Fecha(1,1,1), "path");
        String nombreDeLista = "ListaPart1";
        String imagenDeLista = "ImagenListaPart1";
        Controlador instance = new Controlador();
        instance.addListaParticular(client, nombreDeLista, imagenDeLista);
    }

//    /**
//     * Test of addListaPorDefecto method, of class Controlador.
//     */
    @Test
    public void testAddListaPorDefecto1() {
        System.out.println("addListaPorDefecto1_agregarGeneroNull");
        Genero genero = null;
        String nombreDeLista = "";
        String imagenDeLista = "";
        Controlador instance = new Controlador();
        instance.addListaPorDefecto(genero, nombreDeLista, imagenDeLista);
    }
    
    @Test
    public void testAddListaPorDefecto2() {
        System.out.println("addListaPorDefecto1_agregarGeneroNull");
        Genero genero = new Genero("GeneroTestListaPart1");
        String nombreDeLista = "ListaDef1";
        String imagenDeLista = "ImagenListaDef1";
        Controlador instance = new Controlador();
        instance.addListaPorDefecto(genero, nombreDeLista, imagenDeLista);
    }
//
//    /**
//     * Test of privatizarLista method, of class Controlador.
//     */
    @Test
    public void testPrivatizarLista1() {
        System.out.println("privatizarLista1_listaEsNull_privada");
        ListaParticular lista = null;
        boolean modo = false;
        boolean expResult = false;
        Controlador instance = new Controlador();
        instance.privatizarLista(lista, modo);
        if(lista!=null)  
            assertEquals(expResult, lista.getPrivacidad());            
    }
    
    @Test
    public void testPrivatizarLista2() {
        System.out.println("privatizarLista2_privada");
        ListaParticular lista = new ListaParticular(new Cliente(), "nombre", "imagen");
        boolean modo = false;
        boolean expResult = false;
        Controlador instance = new Controlador();
        instance.privatizarLista(lista, modo);
        if(lista!=null)  
            assertEquals(expResult, lista.getPrivacidad());            
    }
    
    @Test
    public void testPrivatizarLista3() {
        System.out.println("privatizarLista3_publica");
        ListaParticular lista = new ListaParticular(new Cliente(), "nombre", "imagen");
        boolean modo = true;
        boolean expResult = true;
        Controlador instance = new Controlador();
        instance.privatizarLista(lista, modo);
        if(lista!=null)  
            assertEquals(expResult, lista.getPrivacidad());            
    }
//
//    /**
//     * Test of getListByName method, of class Controlador.
//     */
//    @Test
//    public void testGetListByName1() {
//        System.out.println("getListByName1");
//        Cliente user = null;
//        String name = "";
//        Controlador instance = new Controlador();
//        ListaParticular expResult = null;
//        ListaParticular result = instance.getListByName(user, name);
//        assertEquals(expResult, result);
//    }
//

    @Test
    public void testArtistLibre1() {
        System.out.println("artistLibre1_libre");
        Controlador instance = new Controlador();
        String artist = "PepeLibre1";
        boolean expResult = true;
        boolean result = instance.artistLibre(artist);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testArtistLibre2() {
        System.out.println("artistLibre1_ocupado");
        Controlador instance = new Controlador();
        String artist = "PepeLibre2";
        instance.registrarArtista(artist, "", "PepeLibrePail2", "", "", null, "", "", "");    
        boolean expResult = false;        
        boolean result = instance.artistLibre(artist);
        assertEquals(expResult, result);
    }
    
        

//    /**
//     * Test of GuardarTemaFav method, of class Controlador.
//     */
//    @Test
//    public void testGuardarTemaFav() {
//        System.out.println("GuardarTemaFav");
//        Object selectedItem = null;
//        Object selectedItem0 = null;
//        Controlador instance = new Controlador();
//        instance.GuardarTemaFav(selectedItem, selectedItem0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of GuardarAlbumFav method, of class Controlador.
//     */
//    @Test
//    public void testGuardarAlbumFav() {
//        System.out.println("GuardarAlbumFav");
//        Object selectedItem = null;
//        Object selectedItem0 = null;
//        Controlador instance = new Controlador();
//        instance.GuardarAlbumFav(selectedItem, selectedItem0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of DejarSeguirUsuario method, of class Controlador.
//     */
//    @Test
//    public void testDejarSeguirUsuario() {
//        System.out.println("DejarSeguirUsuario");
//        Item seguidor = null;
//        Item seguido = null;
//        Controlador instance = new Controlador();
//        instance.DejarSeguirUsuario(seguidor, seguido);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getListasDefectoItem method, of class Controlador.
//     */
//    @Test
//    public void testGetListasDefectoItem() {
//        System.out.println("getListasDefectoItem");
//        Controlador instance = new Controlador();
//        List expResult = null;
//        List result = instance.getListasDefectoItem();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of GuardarListaFav method, of class Controlador.
//     */
//    @Test
//    public void testGuardarListaFav() {
//        System.out.println("GuardarListaFav");
//        Object selectedItem = null;
//        Object selectedItem0 = null;
//        Controlador instance = new Controlador();
//        instance.GuardarListaFav(selectedItem, selectedItem0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//

//    /**
//     * Test of SeguirUsuario method, of class Controlador.
//     */
//    @Test
//    public void testSeguirUsuario_String_String() {
//        System.out.println("SeguirUsuario");
//        String seguidor = "";
//        String seguido = "";
//        Controlador instance = new Controlador();
//        instance.SeguirUsuario(seguidor, seguido);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of quitarTemaDeLista method, of class Controlador.
//     */
//    @Test
//    public void testQuitarTemaDeLista() {
//        System.out.println("quitarTemaDeLista");
//        Object selectedItem = null;
//        Object selectedItem0 = null;
//        Controlador instance = new Controlador();
//        instance.quitarTemaDeLista(selectedItem, selectedItem0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of QuitarTemaFavorito method, of class Controlador.
//     */
//    @Test
//    public void testQuitarTemaFavorito_Object_Object() {
//        System.out.println("QuitarTemaFavorito");
//        Object selectedItem = null;
//        Object selectedItem0 = null;
//        Controlador instance = new Controlador();
//        instance.QuitarTemaFavorito(selectedItem, selectedItem0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of QuitarAlbumFav method, of class Controlador.
//     */
//    @Test
//    public void testQuitarAlbumFav_Object_Object() {
//        System.out.println("QuitarAlbumFav");
//        Object selectedItem = null;
//        Object selectedItem0 = null;
//        Controlador instance = new Controlador();
//        instance.QuitarAlbumFav(selectedItem, selectedItem0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of QuitarListaFav method, of class Controlador.
//     */
//    @Test
//    public void testQuitarListaFav_Object_Object() {
//        System.out.println("QuitarListaFav");
//        Object selectedItem = null;
//        Object selectedItem0 = null;
//        Controlador instance = new Controlador();
//        instance.QuitarListaFav(selectedItem, selectedItem0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of GuardarTemaFavorito method, of class Controlador.
//     */
//    @Test
//    public void testGuardarTemaFavorito() {
//        System.out.println("GuardarTemaFavorito");
//        Object selectedItem = null;
//        Object selectedItem0 = null;
//        Controlador instance = new Controlador();
//        instance.GuardarTemaFavorito(selectedItem, selectedItem0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of DejarDeSeguirUsuario method, of class Controlador.
//     */
//    @Test
//    public void testDejarDeSeguirUsuario() {
//        System.out.println("DejarDeSeguirUsuario");
//        String seguidor = "";
//        String seguido = "";
//        Controlador instance = new Controlador();
//        instance.DejarDeSeguirUsuario(seguidor, seguido);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of createTemporalAlbum method, of class Controlador.
     */
    @Test
    public void testCreateTemporalAlbum() {
        System.out.println("createTemporalAlbum");
        Controlador instance = new Controlador();
        instance.createTemporalAlbum();
    }

    @Test
    public void testDeleteTemporalAlbum() {
        System.out.println("deleteTemporalAlbum");
        Controlador instance = new Controlador();
        instance.deleteTemporalAlbum();
        
    }
//
    /**
     * Test of configTemporalAlbum method, of class Controlador.
     */
    @Test
    public void testConfigTemporalAlbum() {
        System.out.println("configTemporalAlbum");
        Artista artist = null;
        String nombre = "";
        List<Genero> generos = null;
        int año = 0;
        String imagePath = "";
        Controlador instance = new Controlador();
        instance.configTemporalAlbum(artist, nombre, generos, año, imagePath);
    }

    /**
     * Test of addTemaToM method, of class Controlador.
     */
    @Test
    public void testAddTemaToM() {
        System.out.println("addTemaToM");
        Tema tema = null;
        Controlador instance = new Controlador();
        instance.addTemaToM(tema);
    }

    /**
     * Test of addTemporalAlbum method, of class Controlador.
     */
    @Test
    public void testAddTemporalAlbum() {
        System.out.println("addTemporalAlbum");
        Artista artist = null;
        Controlador instance = new Controlador();
        instance.addTemporalAlbum();
    }

    /**
     * Test of createTemporalGenres method, of class Controlador.
     */
    @Test
    public void testCreateTemporalGenres() {
        System.out.println("createTemporalGenres");
        Controlador instance = new Controlador();
        instance.createTemporalGenres();
    }

    /**
     * Test of addToTemporalGenres method, of class Controlador.
     */
    @Test
    public void testAddToTemporalGenres() {
        System.out.println("addToTemporalGenres");
        Genero genero = null;
        Controlador instance = new Controlador();
        instance.addToTemporalGenres(genero);
    }

    /**
     * Test of wipeTemporalGenres method, of class Controlador.
     */
    @Test
    public void testWipeTemporalGenres() {
        System.out.println("wipeTemporalGenres");
        Controlador instance = new Controlador();
        instance.wipeTemporalGenres();
    }
    
    @Test
    public void testGetTemporalGenres1() {
        System.out.println("getTemporalGenres1_ConTemporalGenres");
        Controlador instance = new Controlador();
        List<Genero> lista = null;
        //lista.add(new Genero());
        List<Genero> expResult = lista;
        List<Genero> result = instance.getTemporalGenres();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTemporalGenres method, of class Controlador.
     */
    @Test
    public void testGetTemporalGenres2() {
        System.out.println("getTemporalGenres2_sinTemporalGenres");
        Controlador instance = new Controlador();
        List<Genero> expResult = null;
        instance.wipeTemporalGenres();
        List<Genero> result = instance.getTemporalGenres();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetTemporalAlbum1() {
        System.out.println("getTemporalAlbum1_ConTemporalAlbum");
        Controlador instance = new Controlador();
        Album expResult = new Album();
        instance.createTemporalAlbum();
        Album result = instance.getTemporalAlbum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTemporalAlbum method, of class Controlador.
     */
    @Test
    public void testGetTemporalAlbum2() {
        System.out.println("getTemporalAlbum2_SinTemporalAlbum");
        Controlador instance = new Controlador();
        Album expResult = null;
        instance.deleteTemporalAlbum();
        Album result = instance.getTemporalAlbum();
        assertEquals(expResult, result);
    }
    
    

    /**
     * Test of absolutePathToRelative method, of class Controlador.
     */
    @Test
    public void testAbsolutePathToRelative() {
        System.out.println("absolutePathToRelative");
        String path = "";
        Controlador instance = new Controlador();
        String expResult = "../WebApp/web/imagenes/default.jpg";
        String result = instance.absolutePathToRelative(path);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of getAlbumsAsItem method, of class Controlador.
//     */
//    @Test
//    public void testGetAlbumsAsItem() {
//        System.out.println("getAlbumsAsItem");
//        Controlador instance = new Controlador();
//        List expResult = null;
//        List result = instance.getAlbumsAsItem();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getListasAsItem method, of class Controlador.
//     */
//    @Test
//    public void testGetListasAsItem() {
//        System.out.println("getListasAsItem");
//        Controlador instance = new Controlador();
//        List expResult = null;
//        List result = instance.getListasAsItem();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
