package Servicio;

import java.util.HashMap;
import Entidad.Producto;
import java.util.Map;

public class ServicioProducto {

    private HashMap<Integer, Producto> productos;
    private Integer id = 1;

    public ServicioProducto() {
        productos = new HashMap<>();
    }

    /**
     * Obtiene los productos agregados hasta el momento
     *
     * @return el hashmap de los productos
     */
    public HashMap<Integer, Producto> obtenerProductos() {
        return productos;
    }

    /**
     * Agrega un producto a la lista de productos
     *
     * @param nombre
     * @param precio
     * @return el nuevo producto creado
     */
    public Producto agregarProducto(String nombre, Double precio) {
        Producto nuevoProducto = new Producto(nombre, precio);
        productos.put(id, nuevoProducto);
        id++;
        return nuevoProducto;
    }

    /**
     * Modifica el nombre y precio del producto que posee id
     *
     * @param id
     * @param nombre
     * @param precio
     * @return el producto modificado o null en caso de no encontrar el id
     */
    public Producto modificarProducto(Integer id, String nombre, Double precio) {
        if (!verificarId(id)) {
            return null;
        }
        Producto productoModificado = productos.get(id);
        productoModificado.setNombre(nombre);
        productoModificado.setPrecio(precio);
        return productoModificado;
    }

    /**
     * Modifica el nombre del producto que posee id
     *
     * @param id
     * @param nombre
     * @return el producto modificado o null en caso de no encontrar el id
     */
    public Producto modificarProducto(Integer id, String nombre) {
        if (!verificarId(id)) {
            return null;
        }
        Producto productoModificado = productos.get(id);
        productoModificado.setNombre(nombre);
        return productoModificado;
    }

    /**
     * Modifica el precio del producto que posee id
     *
     * @param id
     * @param precio
     * @return el producto modificado o null en caso de no encontrar el id
     */
    public Producto modificarProducto(Integer id, Double precio) {
        if (!verificarId(id)) {
            return null;
        }
        Producto productoModificado = productos.get(id);
        productoModificado.setPrecio(precio);
        return productoModificado;
    }

    /**
     * Elimina un producto segun su ID
     *
     * @param id del producto a eliminar
     * @return el producto que ha sido eliminado
     */
    public Producto eliminarProducto(Integer id) {
        if (!verificarId(id)) {
            return null;
        }

        return productos.remove(id);
    }

    /**
     * Elimina un producto de manera SOFT segun su ID
     *
     * @param id
     * @return
     */
    public Producto elminarProductoSoft(Integer id) {
        if (!verificarId(id)) {
            return null;
        }
        Producto productoEliminado = productos.get(id);
        productoEliminado.setActivo(false);
        return productoEliminado;
    }

    /**
     * Obtiene el id del producto segun su nombre
     *
     * @param nombre del producto
     * @return id del producto o -1 en caso de no encontrarlo
     */
    public Integer obtenerIdProducto(String nombre) {

        for (Map.Entry<Integer, Producto> aux : productos.entrySet()) {
            if (aux.getValue().getNombre().equalsIgnoreCase(nombre)) {
                return aux.getKey();
            }
        }
        return -1;
    }

    /**
     * Verifica que el id exista en el listado de productos
     * @param id
     * @return 
     */
    public Boolean verificarId(Integer id) {
        return productos.containsKey(id);
    }

}
