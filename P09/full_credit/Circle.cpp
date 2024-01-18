#include "Circle.h"
#include "math.h"



Circle::Circle(double radius)
    : radius(radius) {
}

double Circle::area() {
    return M_PI * (radius * radius);
}

std::string Circle::name() {
    return "Circle of radius " + std::to_string(radius);
}