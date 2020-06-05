package ArrayBox;

public class ArrayBox<E> {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_CAPACITY=10;
	public ArrayBox() {
		elements=new Object[DEFAULT_CAPACITY];
	}
	public ArrayBox(int capacity) {
		elements=new Object[capacity];
	}
	public Object[] getArray() {
		return this.elements;
	}
	public int getSize() {
		return this.size;
	}
	private void rangeCheck(int index) {
		if(index<0 || index>=size) {
			throw new BoxIndexOutOfBoundsException("index:"+index+",size:"+size);
		}
	}
	private void ensureCapacityInternal(int minCapacity) {
		if(minCapacity - elements.length > 0) {
			this.grow(minCapacity);
		}
	}
	private void grow(int minCapacity) {
		int oldCapacity = elements.length;
		int newCapacity = oldCapacity + (oldCapacity>>1);
		if(newCapacity - minCapacity < 0) {
			newCapacity=minCapacity;
		}
		elements=this.copyOf(elements, newCapacity);
	}
	private Object[] copyOf(Object[] oldArray,int newCapacity) {
		Object[] newArray = new Object[newCapacity];
		for(int i=0;i<oldArray.length;i++) {
			newArray[i]=oldArray[i];
		}
		return newArray;
	}
	public boolean add(E element) {
		this.ensureCapacityInternal(size+1);
		elements[size++]=element;
		return true;
	}
	public E get(int index) {
		this.rangeCheck(index);
		return (E)elements[index];
	}
	public E remove(int index) {
		this.rangeCheck(index);
		E oldValue=(E)elements[index];
		for(int i=index;i<size-1;i++) {
			elements[i]=elements[i+1];
			
		}
		elements[--size]=null;
		return oldValue;
	}
}
