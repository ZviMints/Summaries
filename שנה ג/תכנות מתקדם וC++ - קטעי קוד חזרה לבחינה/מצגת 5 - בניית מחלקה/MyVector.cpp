#include <iostream>
#include <vector>

/** Written By Zvi Mints - zvimints@gmail.com **/
/** Powerpoint 5 **/

template <class Type>
class MyVector {
private: // Its by default private
    unsigned long _size; // the size
    Type* elem; // a pointer to the elements
public:
    using size_type = unsigned long;
    MyVector(): _size{0}, elem(nullptr) { std::cout << "Default Constructor" << std::endl; }
    // MyVector(initializer_list<Type> list) : _size{list.size()}, _elem{new Type[_size]} {}
    MyVector(unsigned long size): _size{size}, elem{new Type[size]} { std::cout << "Long Constructor" << std::endl; for(size_type i = 0; i < size; i++) elem[i] = 0; }
    MyVector(const MyVector& other) { std::cout << "Copy Constructor" << std::endl;
    this->_size = other._size;
    std::copy(other.elem, other._size + other.elem, elem);
    }

    MyVector& operator=(const MyVector& other) { std::cout << "Copy Assignment" << std::endl;
    // Create copy
    Type* p = new Type[other._size];
    std::copy(other.elem, other.elem + other._size, elem);
    // Delete old allocation
    delete[] elem;
    elem = p;
    this->_size = other._size;

    // Retuning reference to *this in order for = ... = ...
    return *this;
    }
    ~MyVector() { std::cout << "~MyVector()" << std::endl; delete[] elem; /** Since we allocate new memory at (int) constructor **/ }

    unsigned long size() { return size; }
};


int main() {
    MyVector<int> v1; // Default Constructor
    MyVector<int> v2(10.0); // Long Constructor
    MyVector<int> v3; // Default Constructor
    v3 = v1; // Copy Assignment
    MyVector<int> v4 = v1; // Copy Constructor
    MyVector<int> v5(v4); // Copy Constructor

    //todo: check the pointer being freed was not allocated and why there only 2 destructors

}