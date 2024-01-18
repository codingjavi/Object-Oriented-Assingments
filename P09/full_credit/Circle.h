#ifndef CIRCLE_H
#define CIRCLE_H

#include "Shape.h"
#include <iostream>

class Circle : public Shape {
public:
    Circle(double radius);
    double area() override;
    std::string name() override;
private:
    double radius;
};

#endif