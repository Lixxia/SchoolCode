#!/usr/bin/env ruby

#Laura Barber
#Ruby Program Assignment 2
#CSCI 320 McCauley
#11/4/13

#1. sum - returns the sum of values in a numeric list that may contain other lists
def sum(list)
	if list.empty?
		return 0
	else
		first, *rest=list
		if first.kind_of?(Array)
			return sum(first) + sum(rest)
		elsif first.is_a?(Integer)
			return first + (sum(rest))
		else
			return sum(rest)
		end
	end
end

#2. remove_odd - return a numeric list with all odd numbers removed
def remove_odd(list)
	if list.empty?
		return list
	else
		first, *rest = list
		if first.kind_of?(Array)
			remove_odd(rest).unshift(remove_odd(first))
		else
			if first.odd?
				return remove_odd(rest)
			else
				return remove_odd(rest).unshift(first)
			end
		end
	end
end

#3. digits - return the length of an integer
def digits(num)
	if num.div(10).zero?
		return 1
	else
		num = num.div(10)
		return 1 + digits(num)
	end	
end

#4. ith_digit - return the ith digit of an integer (digits counted right to left)
def ith_digit(num, i)
	if i.zero?
		return num.modulo(10)
	else
		return ith_digit(num.div(10),i-1)
	end
end

#5. occurences - return the number of occurences of the same digit in a given number
#NOTE: Does not work properly in repl.it 
def occurrences(num, r)
	if num.div(10).zero?
		if num.modulo(10) == r
			return 1
		else
			return 0
		end
	else
		if num.modulo(10) == r
			return 1 + occurrences(num.div(10),r)
		else
			return occurrences(num.div(10),r)
		end
	end
end

#6. digital_sum - return the sum of the digits
def digital_sum(num)
	if num.div(10).zero?
		return num.modulo(10)
	else
		return num.modulo(10) + digital_sum(num.div(10))
	end
end

#7. digital_root - returns the sum of the digits in the sum, until a single digit remains
def digital_root(num)
	if num.div(10).zero?
		return num
	else
		return digital_root(digital_sum(num))
	end
end

#yay testing
puts 'Testing sum: returns the sum of values in a numeric list'
print 'When the list is [2, 5, [3, 5], 1] the sum is '
puts sum([2, 5, [3, 5], 1])
print 'When the list is [1, [4,7], [2, 2], 4, 1] the sum is '
puts sum([1, [4,7], [2, 2], 4, 1])
print 'When the list is [1, [4,[6, 7]], 2, 5, 8] the sum is '
puts sum([1, [4,[6, 7]], 2, 5, 8])

puts ''

puts 'Testing remove_odd: return a numeric list with all odd numbers removed'
print 'When the list is [2, 5, [3, 5], 1] the list without odds is '
puts remove_odd([2, 5, [3, 5], 1]).inspect
print 'When the list is [1, [4,7], [2, 2], 4, 1] the list without odds is '
puts remove_odd([1, [4,7], [2, 2], 4, 1]).inspect
print 'When the list is [1, [4,[6, 7]], 2, 5, 8] the list without odds is '
puts remove_odd([1, [4,[6, 7]], 2, 5, 8]).inspect

puts ''

puts 'Testing digits: returns the length of an integer. '
print 'When the integer is 123456 the length is '
puts digits(123456)
print 'When the integer is 64573922 the length is '
puts digits(64573922)
print 'When the integer is 42 the length is '
puts digits(42)

puts ''

puts 'Testing ith_digit: returns the ith digit of an integer counting from right to left. '
print 'When the integer is 123456 the 2nd digit is '
puts ith_digit(123456,2)
print 'When the integer is 64573922 the 5th digit is '
puts ith_digit(64573922,5)
print 'When the integer is 42 the 1st digit is '
puts ith_digit(42,1)

puts ''

puts 'Testing occurence: returns the number of occurences of some digit in a given number. '
print 'When the number is 12333563, 3 occurs '
print occurrences(12333563,3)
puts ' times.'
print 'When the number is 444444, 4 occurs '
print occurrences(444444444444,4)
puts ' times.'
print 'When the number is 1295876, 3 occurs '
print occurrences(1295876,3)
puts ' times.'

puts ''

puts 'Testing digital_sum: return the sum of the digits.'
print 'When the number is 99999999999 the sum is '
puts digital_sum(99999999999)
print 'When the number is 123456 the sum is '
puts digital_sum(123456)
print 'When the number is 549 the sum is '
puts digital_sum(549)

puts ''

puts 'Testing digital_root: returns the sum of the digits in the sum, until a single digit remains.'
print 'When the number is 99999999999 the digital root is '
puts digital_root(99999999999)
print 'When the number is 123456 the digital root is '
puts digital_root(123456)
print 'When the number is 15 the digital root is '
puts digital_root(15)
