#!/usr/bin/env ruby

#Laura Barber
#Ruby Program Assignment 1
#CSCI 320 McCauley
#11/4/13


#Test functions:
double = lambda{|x| x*2}
add1 = lambda{|x| x + 1}
add2 = lambda{|x| x + 2}
mult3 = lambda {|x| 3 * x}
square = lambda{|x| x + 2}
half = lambda{|x| x / 2}

#Composition: returns a proc that, when called with some parameter x, 
#returns the result of applying f(g(x))
f = lambda{|x| x + 2}
g = lambda {|x| 3 * x}

def compose(f, g)
	return lambda {|x| f.call(g.call(x))}
end

#Construction: takes a list of functions as parameters and returns a
#proc that, when called, computes the composition, given an argument.

g = lambda{|x| x * x}
h = lambda{|x| 2 * x}
i = lambda{|x| x/2}

def construct(list)
	return lambda {|y| list.map{|x| x.call(y)}}
end

#Apply_to_all: takes a function as parameter and returns a proc that, when called,
#applies the function to all elements in a list of values, provided as a parameter. 
j = lambda{|x| x*x}

def apply_to_all(func)
	return lambda{|y| y.map{|x| func.call(x)}}
end

#Tests for Composition
puts 'Testing Composition with f(g(x))'
puts 'f(x) = x+2, g(x) = 3 * x'
print 'When x is 3: f(g(x)) is '
x = compose(f,g)
puts x.call(3)
print 'When x is 2: f(g(x)) is '
x = compose(f,g)
puts x.call(2)
print 'When x is 5: f(g(x)) is '
x = compose(f,g)
puts x.call(5)

puts ''	#nl

#Tests for  Construct
puts 'Testing Construct with [g, h, i]'
puts 'g(x) = x*x, h(x) = 2 * x, i(x) = x/2'
print 'When x is 4: [g(x), h(x), i(x)] is '
y = construct([g,h,i])
puts y.call(4).join(" ,")
print 'When x is 5: [g(x), h(x), i(x)] is '
y = construct([g,h,i])
puts y.call(5).join(" ,")
print 'When x is 10: [g(x), h(x), i(x)] is '
y = construct([g,h,i])
puts y.call(10).join(" ,")

puts ''	#nl

#Tests for  Apply_to_all
puts 'Testing Apply_to_all with j(x)'
puts 'j(x) = x * x'
print 'When list of values is [12, 39, -2, 1]: j(x) is '
z = apply_to_all(j)
puts z.call([12, 39, -2, 1]).join(" ,")

print 'When list of values is [2, 4, 8]: j(x) is '
z = apply_to_all(j)
puts z.call([2,4,8]).join(" ,")
print 'When list of values is [-1, 2, 3]: j(x) is '
z = apply_to_all(j)
puts z.call([-1,2,3]).join(" ,")
