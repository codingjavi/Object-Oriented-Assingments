#include "Index.h"
#include <iostream>
#include <map>
#include <set>

void Index::add_word(const Word& word, const std::string& filename, int line) {
    if (!word.empty()) {
        Word modifiedWord = word;  //copy of word

        //checking if its anything but letter and number
        while (!std::isalnum(modifiedWord.front())) {
            modifiedWord.erase(0, 1);
        }

        while (!std::isalnum(modifiedWord.back())) {
            modifiedWord.pop_back();
        }

        for (char& c : modifiedWord) {
            c = std::tolower(c);
        }

        //construct and insert
        index[modifiedWord].emplace(filename, line);
    }
}

std::ostream& operator<<(std::ostream& os, const Index& index) {
    for (const auto& entry : index.index) {
        os << entry.first << ": ";
        for (const auto& location : entry.second) {
            os << location << ", ";
        }
        os << '\n';
    }
    return os;
}