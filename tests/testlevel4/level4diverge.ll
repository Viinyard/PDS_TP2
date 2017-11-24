; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [5 x i8]c"Toto\00", align 1
@.str2 = private unnamed_addr constant [3 x i8]c"%s\00", align 1

define void @main() {
entry:
	%0 = getelementptr inbounds [5 x i8], [5 x i8]* @.str1, i32 0, i32 0
	%1 = getelementptr inbounds [3 x i8], [3 x i8]* @.str2, i32 0, i32 0
	%2 = call i32 (i8*, ...) @printf(i8* %1, i8* %0)
	%3 = alloca i32
	store i32 10, i32* %3
	br label %entry1
entry1:
	%4 = load i32, i32* %3
	%5 = sub i32 %4, 1
	%6 = icmp ne i32 %5, 0
	br i1 %6, label %do2, label %done3
do2:
	%7 = alloca i32
	store i32 1, i32* %7
	br label %entry1
done3:
	ret void 
}


