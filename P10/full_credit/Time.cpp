#include "Time.h"
#include <iostream>
#include <iomanip>

Time::Time(int hour, int minute, int second)
    : hour(hour), minute(minute), second(second) {
        //validating the fields
        rationalize();
    }

void Time::rationalize() {
    // dereferencing the current object and getting the fields
    this->hour = (hour >= 0 && hour <= 23) ? hour : 0;
    this->minute = (minute >= 0 && minute <= 59) ? minute : 0;

    //negative seconds
    while (second < 0) {
        second += 60;
        --minute;
    }

    //overflow
    this->minute += second / 60;
    this->second %= 60;

    this->hour += this->minute / 60;
    this->minute %= 60;

    this->hour %= 24;
}

//implementing the rest of the operations
std::istream& operator>>(std::istream& is, Time& time) {
    char buffer, buffer1;

    //reading the input from stream
    if(!(is >> time.hour >> buffer >> time.minute >> buffer1 >> time.second)) {
        is.setstate(std::ios::failbit);
        return is;
    }

    if (buffer != ':' || buffer1 != ':') {
        is.setstate(std::ios::failbit);
        return is;
    }
    time.rationalize();
    return is;
}

std::ostream& operator<<(std::ostream& os, const Time& time) {
    //making 2 digit fields with leading zeros
    os << std::setfill('0') << std::setw(2) << time.hour << ':'
       << std::setfill('0') << std::setw(2) << time.minute << ':'
       << std::setfill('0') << std::setw(2) << time.second;

    return os;
}

Time Time::operator+(Time time) const {
    Time result(0, 0, 0);

    //addind the fields
    result.second = this->second + time.second;
    result.minute = this->minute + time.minute;
    result.hour = this->hour + time.hour;

    result.rationalize();
    return result;
}

//preincrement operator (++time)
Time& Time::operator++() {
    //increment the time and rationalize
    ++second;
    rationalize();
    return *this;
}

//postincrement operator (time++)
Time Time::operator++(int add) {
    Time temp = *this; 
    ++(*this);
    return temp;       
}

bool Time::operator==(const Time& time) const {
    return hour == time.hour && minute == time.minute && second == time.second;
}

bool Time::operator!=(const Time& time) const {
    return !(*this == time);
}

bool Time::operator<(const Time& time) const {
    if (hour == time.hour) {
        if (minute == time.minute) {
            return second < time.second;
        }
        return minute < time.minute;
    }
    return hour < time.hour;
}

bool Time::operator>(const Time& time) const {
    return !(*this <= time);
}

bool Time::operator<=(const Time& time) const {
    return (*this < time) || (*this == time);
}

bool Time::operator>=(const Time& time) const {
    return !(*this < time);
}