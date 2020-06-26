#include <iostream>


/** Written By Zvi Mints - zvimints@gmail.com **/
/** Powerpoint 5 **/

/*
 * Difference between class Person and struct Person
 * is that:
 * 1) Members of a class are private by default and members of a struct are public by default
 * 2) When deriving a struct from a class/struct, default access-specifier for a base class/struct is public.
 *     And when deriving a class, default access specifier is private, means that:
 *       2.1) class B : A {} when A is a class is equiv to class B : private A {}
 *       2.2) struct B : A {} when A is a struct is equiv to struct B : public A {}
 */
struct Person {
    Person() = default;
    public: int _public = 0;
    protected: int _protected = 0;
    private: int _private = 0;
};

class PrivatePerson : private Person {};
class ProtectedPerson : protected Person {};
class PublicPerson : public Person {};
class VeryPrivatePerson : public PrivatePerson {};

int main() {

    Person p;
    std::cout << p._public << std::endl;
    // std::cout << p._protected << std::endl; // compile error: error: '_protected' is a protected member of 'Person'
    // std::cout << p._private << std::endl; // compile error:  error: '_private' is a private member of 'Person'

    PublicPerson _publicPerson;
    std::cout << _publicPerson._public << std::endl;
    // Other is compile error

    ProtectedPerson _protectedPerson;
    // std::cout << _protectedPerson._public << std::endl; // compile error: error: cannot cast 'ProtectedPerson' to its protected base class 'Person'

    VeryPrivatePerson _veryPrivatePerson; // All private here


    return 0;
}