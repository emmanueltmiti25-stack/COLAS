public class Nodo<T> {
    private T elemento;
    private Nodo<T> siguiente;

    public Nodo(T elemento, Nodo<T> siguiente) {
        this.elemento = elemento;
        this.siguiente = siguiente;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}

public class ColaDinamica<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamaño;

    public ColaDinamica() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public int size() {
        return tamaño;
    }

    public T primero() {
        if (isEmpty()) {
            return null;
        }
        return primero.getElemento();
    }

    public T enqueue(T elemento) {
        Nodo<T> aux = new Nodo<>(elemento, null);

        if (isEmpty()) {
            primero = aux;
        } else {
            ultimo.setSiguiente(aux);
        }

        ultimo = aux;
        tamaño++;
        return aux.getElemento();
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T elemento = primero.getElemento();
        primero = primero.getSiguiente();
        tamaño--;

        if (isEmpty()) {
            ultimo = null;
        }

        return elemento;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "La cola está vacía";
        }
        StringBuilder cadena = new StringBuilder();
        Nodo<T> aux = primero;
        while (aux != null) {
            cadena.append(aux.getElemento().toString()).append(" ");
            aux = aux.getSiguiente();
        }
        return cadena.toString().trim();
    }
}