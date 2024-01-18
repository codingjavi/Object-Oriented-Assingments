#ifndef __RECTANGLE_H
#define __RECTANGLE_H
#include "Shape.h"
#include <iostream>

class Rectangle : public Shape {
public:
    Rectangle(double height, double width);
    double area() override;
    std::string name() override;
private:
    double height, width;
};

#endif