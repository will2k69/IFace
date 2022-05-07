public class UserData<T> {
    private T value;

    public UserData(T valor) {
        setValue(valor);
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T valor) {
        this.value = valor;
    }
}