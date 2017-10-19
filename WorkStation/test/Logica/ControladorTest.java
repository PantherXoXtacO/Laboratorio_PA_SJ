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
    public void T001_testRegistrarCliente() {
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
    public void T002_testRegistrarArtista() {
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
    public void T003_testGetListaClientes() {
        System.out.println("getListaClientes");
        Controlador instance = new Controlador();
        int cantExpetc = 1;
        List<Cliente> result = instance.getListaClientes();
        int cantResult = result.size();
        assertEquals(cantExpetc, cantResult);
    }
//
//    /**
//     * Test of AltaGenero method, of class Controlador.
//     */
    @Test
    public void T004_testAltaGenero() {
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
    public void T005_testAltaGenero2() {
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
    public void T006_testAltaGenero3() {
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
    public void T007_testAltaGenero4() {
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
    public void T008_testAltaGenero5() {
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
    
    @Test
    public void T009_testAltaGenero6() {
        System.out.println("AltaGenero6");
        String nombre = "TestGenero454545";
        String padre = "generoFalso";
        Controlador instance = new Controlador();
        instance.AltaGenero(nombre, padre);
        List result = instance.getGeneroItem();
        int cantExpect = result.size();
        int cantResult = cantExpect;
        assertEquals(cantExpect, cantResult);
    }
    
    @Test
    public void T010_testAltaGenero7() {
        System.out.println("AltaGenero7");
        String nombre = "General";
        String padre = "";
        Controlador instance = new Controlador();
        instance.AltaGenero(nombre, padre);
        List result = instance.getGeneroItem();
        int cantExpect = result.size();
        int cantResult = cantExpect;
        assertEquals(cantExpect, cantResult);
    }

//
//    /**
//     * Test of GetGenero method, of class Controlador.
//     */
    @Test
    public void T011_testGetGenero() {
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
    public void T012_testGetGeneroPorNombre() {
        System.out.println("getGeneroPorNombre");
        String nombre = "TestGenero";
        Controlador instance = new Controlador();
        Genero result = instance.getGeneroPorNombre(nombre);
        assertEquals(nombre, result.getNombre());
    }
    
    @Test
    public void T013_testGetGeneroPorNombre2() {
        System.out.println("getGeneroPorNombre");
        String nombre = "GeneroFalso";
        Controlador instance = new Controlador();
        Genero result = instance.getGeneroPorNombre(nombre);
        assertEquals(null, result);
    }

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
//
//    /**
//     * Test of mailLibre method, of class Controlador.
//     */
//    @Test
//    public void testMailLibre() {
//        System.out.println("mailLibre");
//        String mail = "";
//        Controlador instance = new Controlador();
//        boolean expResult = false;
//        boolean result = instance.mailLibre(mail);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of consultarCliente method, of class Controlador.
//     */
//    @Test
//    public void testConsultarCliente() {
//        System.out.println("consultarCliente");
//        String nickname = "";
//        Controlador instance = new Controlador();
//        Cliente expResult = null;
//        Cliente result = instance.consultarCliente(nickname);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of consultarArtista method, of class Controlador.
//     */
//    @Test
//    public void testConsultarArtista() {
//        System.out.println("consultarArtista");
//        String nickname = "";
//        Controlador instance = new Controlador();
//        Artista expResult = null;
//        Artista result = instance.consultarArtista(nickname);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
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
//    @Test
//    public void testAddListaParticular() {
//        System.out.println("addListaParticular");
//        Cliente client = null;
//        String nombreDeLista = "";
//        String imagenDeLista = "";
//        Controlador instance = new Controlador();
//        instance.addListaParticular(client, nombreDeLista, imagenDeLista);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addListaPorDefecto method, of class Controlador.
//     */
//    @Test
//    public void testAddListaPorDefecto() {
//        System.out.println("addListaPorDefecto");
//        Genero genero = null;
//        String nombreDeLista = "";
//        String imagenDeLista = "";
//        Controlador instance = new Controlador();
//        instance.addListaPorDefecto(genero, nombreDeLista, imagenDeLista);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of privatizarLista method, of class Controlador.
//     */
//    @Test
//    public void testPrivatizarLista() {
//        System.out.println("privatizarLista");
//        ListaParticular lista = null;
//        boolean modo = false;
//        Controlador instance = new Controlador();
//        instance.privatizarLista(lista, modo);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getListByName method, of class Controlador.
//     */
//    @Test
//    public void testGetListByName() {
//        System.out.println("getListByName");
//        Cliente user = null;
//        String name = "";
//        Controlador instance = new Controlador();
//        ListaParticular expResult = null;
//        ListaParticular result = instance.getListByName(user, name);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of artistLibre method, of class Controlador.
//     */
//    @Test
//    public void testArtistLibre() {
//        System.out.println("artistLibre");
//        String artistAlbum = "";
//        Controlador instance = new Controlador();
//        boolean expResult = false;
//        boolean result = instance.artistLibre(artistAlbum);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
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
//     * Test of AgregarTema method, of class Controlador.
//     */
//    @Test
//    public void testAgregarTema() {
//        System.out.println("AgregarTema");
//        Usuario user = null;
//        Controlador instance = new Controlador();
//        instance.AgregarTema(user);
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
//    /**
//     * Test of createTemporalAlbum method, of class Controlador.
//     */
//    @Test
//    public void testCreateTemporalAlbum() {
//        System.out.println("createTemporalAlbum");
//        Controlador instance = new Controlador();
//        instance.createTemporalAlbum();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteTemporalAlbum method, of class Controlador.
//     */
//    @Test
//    public void testDeleteTemporalAlbum() {
//        System.out.println("deleteTemporalAlbum");
//        Controlador instance = new Controlador();
//        instance.deleteTemporalAlbum();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of configTemporalAlbum method, of class Controlador.
//     */
//    @Test
//    public void testConfigTemporalAlbum() {
//        System.out.println("configTemporalAlbum");
//        Artista artist = null;
//        String nombre = "";
//        List<Genero> generos = null;
//        int año = 0;
//        String imagePath = "";
//        Controlador instance = new Controlador();
//        instance.configTemporalAlbum(artist, nombre, generos, año, imagePath);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addTemaToM method, of class Controlador.
//     */
//    @Test
//    public void testAddTemaToM() {
//        System.out.println("addTemaToM");
//        Tema tema = null;
//        Controlador instance = new Controlador();
//        instance.addTemaToM(tema);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addTemporalAlbum method, of class Controlador.
//     */
//    @Test
//    public void testAddTemporalAlbum() {
//        System.out.println("addTemporalAlbum");
//        Artista artist = null;
//        Controlador instance = new Controlador();
//        instance.addTemporalAlbum(artist);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createTemporalGenres method, of class Controlador.
//     */
//    @Test
//    public void testCreateTemporalGenres() {
//        System.out.println("createTemporalGenres");
//        Controlador instance = new Controlador();
//        instance.createTemporalGenres();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addToTemporalGenres method, of class Controlador.
//     */
//    @Test
//    public void testAddToTemporalGenres() {
//        System.out.println("addToTemporalGenres");
//        Genero genero = null;
//        Controlador instance = new Controlador();
//        instance.addToTemporalGenres(genero);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of wipeTemporalGenres method, of class Controlador.
//     */
//    @Test
//    public void testWipeTemporalGenres() {
//        System.out.println("wipeTemporalGenres");
//        Controlador instance = new Controlador();
//        instance.wipeTemporalGenres();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTemporalGenres method, of class Controlador.
//     */
//    @Test
//    public void testGetTemporalGenres() {
//        System.out.println("getTemporalGenres");
//        Controlador instance = new Controlador();
//        List<Genero> expResult = null;
//        List<Genero> result = instance.getTemporalGenres();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTemporalAlbum method, of class Controlador.
//     */
//    @Test
//    public void testGetTemporalAlbum() {
//        System.out.println("getTemporalAlbum");
//        Controlador instance = new Controlador();
//        Album expResult = null;
//        Album result = instance.getTemporalAlbum();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of absolutePathToRelative method, of class Controlador.
//     */
//    @Test
//    public void testAbsolutePathToRelative() {
//        System.out.println("absolutePathToRelative");
//        String path = "";
//        Controlador instance = new Controlador();
//        String expResult = "";
//        String result = instance.absolutePathToRelative(path);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
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
