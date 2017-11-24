; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [7 x i8]c"1+3 = \00", align 1
@.str2 = private unnamed_addr constant [5 x i8]c"%s%d\00", align 1

define void @main() {
entry:
	%0 = getelementptr inbounds [7 x i8], [7 x i8]* @.str1, i32 0, i32 0
	%1 = call i32 @plus(i32 1, i32 3)
	%2 = getelementptr inbounds [5 x i8], [5 x i8]* @.str2, i32 0, i32 0
	%3 = call i32 (i8*, ...) @printf(i8* %2, i8* %0, i32 %1)
	ret void 
}

define i32 @plus(i32, i32) {
entry:
	%2 = alloca i32
	%3 = alloca i32
	store i32 %0, i32* %2
	store i32 %1, i32* %3
	%4 = alloca i32
	%5 = load i32, i32* %2
	%6 = load i32, i32* %3
	%7 = add i32 %5, %6
	store i32 %7, i32* %4
	%8 = load i32, i32* %4
	ret i32 %8
}


