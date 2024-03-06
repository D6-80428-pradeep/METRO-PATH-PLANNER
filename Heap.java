import java.util.ArrayList;
import java.util.HashMap;

//class represents a generic Heap data structure that can hold any type T that extends Comparable
public class Heap<T extends Comparable<T>>
{
    // This List holds the data in the heap
    ArrayList<T> data = new ArrayList<>();
    // This HashMap maps each item in the heap to its index in the ArrayList
    HashMap<T, Integer> map = new HashMap<>();

    // This method adds an item to the heap
    public void add(T item)
    {
        // Add the item to the end of the ArrayList
        data.add(item);
        // Map the item to its index in the ArrayList
        map.put(item, this.data.size() - 1);
        // Restore the heap property by moving the added item to its correct position
        upheapify(data.size() - 1);
    }

    // This method restores the heap property by moving an item up the heap until it's in the correct position
    private void upheapify(int ci)
    {

        // Calculate the index of the parent item
        int pi = (ci - 1) / 2;
        // If the child item is larger than the parent item, swap them and continue up the heap
        if (isLarger(data.get(ci), data.get(pi)) > 0)
        {
            swap(pi, ci);
            upheapify(pi);
        }
    }

    // This method swaps two items in the heap
    private void swap(int i, int j)
    {
        // Get the items at the given indices
        T ith = data.get(i);
        T jth = data.get(j);

        // Swap the items in the ArrayList
        data.set(i, jth);
        data.set(j, ith);
        // Update the map with the new indices
        map.put(ith, j);
        map.put(jth, i);
    }

    // This method prints the data in the heap
    public void display()
    {
        System.out.println(data);
    }

    // This method returns the number of items in the heap
    public int size()
    {
        return this.data.size();
    }

    // This method checks if the heap is empty
    public boolean isEmpty()
    {
        return this.size() == 0;
    }

    // This method removes and returns the largest item in the heap
    public T remove()
    {
        // Swap the first item and the last item in the ArrayList
        swap(0, this.data.size() - 1);
        // Remove the last item in the ArrayList
        T rv = this.data.remove(this.data.size() - 1);
        // Restore the heap property by moving the first item to its correct position
        downheapify(0);

        // Remove the item from the map
        map.remove(rv);
        return rv;
    }

    // This method restores the heap property by moving an item down the heap until it's in the correct position
    private void downheapify(int pi)
    {
        // Calculate the indices of the left and right child items
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;
        // Assume the parent item is the smallest
        int mini = pi;

        // If the left child exists and is larger than the current smallest, update the smallest
        if (lci < this.data.size() && isLarger(data.get(lci), data.get(mini)) > 0)
        {
            mini = lci;
        }

        // If the right child exists and is larger than the current smallest, update the smallest
        if (rci < this.data.size() && isLarger(data.get(rci), data.get(mini)) > 0)
        {
            mini = rci;
        }
        // If the smallest item is not the parent, swap the parent with the smallest and continue down the heap
        if (mini != pi)
        {
            swap(mini, pi);
            downheapify(mini);
        }
    }

    // This method returns the largest item in the heap
    public T get()
    {
        return this.data.get(0);
    }

    // This method compares two items and returns a positive number if the first item is larger, 0 if they're equal, and a negative number if the second item is larger
    public int isLarger(T t, T o)
    {

        return t.compareTo(o);
    }

    // This method updates the position of an item in the heap after its priority has been changed
    public void updatePriority(T pair)
    {
        // Get the index of the item in the ArrayList
        int index = map.get(pair);
        // Restore the heap property by moving the item to its correct position
        upheapify(index);
    }
}