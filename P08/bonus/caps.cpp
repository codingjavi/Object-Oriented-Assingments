#include <iostream>
#include <vector>

int main(int argc, char* argv[]) {
    std::vector<std::string> caps;
    std::vector<std::string>* noCaps = new std::vector<std::string>;

    for(int i =1; i < argc; ++i) {
        std::string word = argv[i];

        if (!word.empty()) {
            if (isupper(word[0])){
                caps.push_back(word);
            }
            else {
                noCaps -> push_back(word);
            }

        }
    }

    std::cout << "Capitalized: \n";
    for (size_t i = 0; i < caps.size(); ++i) {
        std::cout << caps[i] << "\n";
    }

    std::cout << "\nLower Case: \n";
    for (size_t i = 0; i < noCaps->size(); ++i) {
        std::cout << (*noCaps)[i] << "\n";
    }

    return 0;
}
