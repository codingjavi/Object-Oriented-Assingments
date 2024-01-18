#ifndef LOCATION_H
#define LOCATION_H
#include <iostream>

class Location {
public:
    Location(std::string filename, int line);
    friend std::ostream& operator<<(std::ostream& os, const Location& location);
    bool operator==(const Location& location) const;
    bool operator<(const Location& location) const;
    bool operator>(const Location& location) const;
    bool operator<=(const Location& location) const;
    bool operator>=(const Location& location) const;
    bool operator!=(const Location& location) const;


private:
    std::string filename;
    int line;
};

#endif