#include "Location.h"
#include <iostream>

Location::Location(std::string filename, int line)
    : filename(filename), line(line) {}

std::ostream& operator<<(std::ostream& os, const Location& location) {
    os << location.filename << " line " << location.line;

    return os;
}

bool Location::operator==(const Location& location) const {
    return filename == location.filename && line == location.line;
}

bool Location::operator!=(const Location& location) const {
    return !(*this == location);
}

//sorting done here
bool Location::operator<(const Location& location) const {
    //comparing the current private fields with the fields of the passed in object
    if(filename != location.filename) {
        return filename < location.filename;
    }
    return line < location.line;
}

bool Location::operator>(const Location& location) const {
    return !(*this <= location);
}

bool Location::operator<=(const Location& location) const {
    return (*this < location) || (*this == location);
}

bool Location::operator>=(const Location& location) const {
    return !(*this < location);
}