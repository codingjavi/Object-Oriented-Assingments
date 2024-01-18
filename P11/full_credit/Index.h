#ifndef INDEX_H
#define INDEX_H
#include <map>
#include <set>
#include <iostream>
#include "Location.h"
typedef std::string Word;
typedef std::set<Location> Locations;

class Index {
public:
    void add_word(const Word& word, const std::string& filename, int line);
    friend std::ostream& operator<<(std::ostream& os, const Index& index);

private:
    std::map<Word, Locations> index;
};

#endif