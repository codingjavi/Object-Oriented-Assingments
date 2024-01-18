#include "Rectangle.h"


Rectangle::Rectangle(double height, double width)
    : height(height), width(width) {
}

double Rectangle::area() {
    return height * width;
}

std::string Rectangle::name() {
    return std::to_string(height) + " by " + std::to_string(width) + " Rectangle";
}