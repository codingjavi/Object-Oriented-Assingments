#ifndef TIME_H
#define TIME_H
#include <iostream>

class Time {
public:
    //operator overloading: giving meaning to +. ==. <<
        //friend: allowing it to access private members of the class
        //no frieds: we're not deliveratly getting private members
            //AND is overloaded as a member function of Time
        //data type returning& operator(operatation) const(dont modify object);
        //returnin a reference to time: &
        
    //setting the constructur with midnight default values
    Time(int hours = 0, int minutes = 0, int seconds = 0);
    Time operator+(Time time) const;
    Time& operator++() ;
    Time operator++(int add) ;
    friend std::ostream& operator<<(std::ostream& os, const Time& time);
    friend std::istream& operator>>(std::istream& is, Time& time);
    bool operator==(const Time& time) const;
    bool operator<(const Time& time) const;
    bool operator>(const Time& time) const;
    bool operator<=(const Time& time) const;
    bool operator>=(const Time& time) const;
    bool operator!=(const Time& time) const;
    


private:
    int hour, minute, second;
    void rationalize();
};

#endif 