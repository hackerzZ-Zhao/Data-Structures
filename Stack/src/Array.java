import sun.font.TrueTypeFont;
import sun.jvm.hotspot.oops.ObjectHeap;

public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }
    public Array(){
        this(10);
    }
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void addFirst(E e){
        add(0, e);
    }
    public void addLast(E e){
        add(size, e);
    }
    public void add(int index, E e){
        if (size == data.length)
            resize(2 * data.length);
        if (index < 0 || index > size)
            throw new IllegalArgumentException();
        for (int i = size - 1; i >= index; i --)
            data[i + 1] = data[i];

        data[index] = e;
        size ++;
    }
    @Override // 覆盖一个父类时若父类不存在时会报错
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size ; i ++){
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        return data[index];
    }
    public E getLast(){
        return get(size - 1);
    }
    public E getFirst(){
        return get(0);
    }
    void set(int index, E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        data[index] = e;
    }
    public boolean contains(E e){
        for(int i = 0; i < size; i ++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }
    public int find(E e){
        for(int i = 0; i < size; i ++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }
    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        E ret = data[index];
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size - 1);
    }
    public void removeElement(E e){
        int index = find(e);
        if (index != -1)
            remove(index);
    }
    private void resize(int newCapacity){
        E[] newData =(E[]) new Object[newCapacity];
        for(int i = 0; i < size; i ++){
            newData[i] = data[i];
        }
        data = newData;
    }

}


