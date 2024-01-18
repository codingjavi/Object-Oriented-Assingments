#include <iostream>
#include <fstream>
#include <sstream>
#include "Index.h"

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << "Not enough arguments passed in" << std::endl;
        return 1;
    }

    Index index;

    for (int i = 1; i < argc; ++i) {
        std::ifstream file(argv[i]);
        if (!file.is_open()) {
            std::cerr << "Error: cant open file " << argv[i] << std::endl;
            continue;
        }

        std::string line;
        int line_number = 1;

        //getting line and parsing into words
        while (std::getline(file, line)) {
            std::istringstream iss(line);
            std::string word;

            while (iss >> word) {
                //getting rid of punctiations in add_word
                index.add_word(word, argv[i], line_number);
            }

            ++line_number;
        }

        file.close();
    }

    std::cout << index;

    return 0;
}