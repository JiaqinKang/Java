import java.util.Arrays;
import java.util.Objects;

public class MyMiniList <T> implements MiniList<T> {
    T[] objectStore = (T[]) new Object[10];
    int variable_size = 0;

    @Override
    public void add(T element) {
        //check array if it has space
        if (objectStore[objectStore.length - 1] != null) {
            int oldArrayLength = size();
            //copy the array list and expand the array length
            //reference  https://stackoverflow.com/questions/13197702/resize-an-array-while-keeping-current-elements-in-java
            objectStore = Arrays.copyOf(objectStore, objectStore.length * 2);
            //add element
            //original length 10 checking position 10-1=9 (original last position)
            //double length to 10*2 = 20 to add new element
            //the next available position will be the size of the old array length
            objectStore[oldArrayLength] = element;
        } else {//else use the size to the next index to add to
            objectStore[size()] = element;
        }
    }

    @Override
    public T get(int index) {
        try {Objects.checkIndex(index,objectStore.length);
            return (T) objectStore[index];//return the element
            }catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    @Override
    public int getIndex(T element) {
        //for loop to check every position if element exist start position 0 to last position
        for (int i = 0 ; i < objectStore.length-1 ; i ++){
            if (objectStore[i] == element){
                return i;//return the element position
            }
        }
        return -1;//return -1 if element is not found
    }

    @Override
    public void set(int index, T element) {
        try {
            if (objectStore[index] != null){
                objectStore[index] = element;
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("invalid index");
        }
    }

    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < objectStore.length; i ++){
            if (objectStore[i] != null){
                count++;
            }
        }
        variable_size =count;
        return variable_size;
    }

    @Override
    public T remove(int index) {
        try {
            T temp = objectStore[index]; // store the old value
            //remove the element by simply assign the next value to the current position, iterate through the array
            for(int i = index ; i < objectStore.length -1; i++){
                objectStore[i] = objectStore [i +1];
                //break early when current value is null and next value is null
                if (objectStore[i] == null) break; //this makes it faster and stop assigning null to null
            }
            //return the element that was deleted
            return temp;
        }catch (IndexOutOfBoundsException e){
            System.out.println("invalid input");
            return null;
        }
    }

    @Override
    public boolean remove(T element) {
        try {
            //find the position of the element if is found and use the index to move every index+1 to index
            for(int i = getIndex(element) ; i < objectStore.length -1; i++){
                objectStore[i] = objectStore [i+1];//close the gaps
                //break early when current value is null and next value is null
                if (objectStore[i] == null) break; //this makes it faster and stop assigning null to null
            }
            return true;//return true
        }catch (IndexOutOfBoundsException e){
            return false;//return false when not found
        }
    }

    @Override
    public void clear() {
        Arrays.fill(objectStore, null);
    }

//    @Override
//    public String toString() {
//        return "MyMiniList{" +
//                "objectStore=" + Arrays.toString(objectStore) +
//                '}';
//    }
}
