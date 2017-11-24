; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [3 x i8]c"f(\00", align 1
@.str2 = private unnamed_addr constant [5 x i8]c") = \00", align 1
@.str3 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str4 = private unnamed_addr constant [11 x i8]c"%s%d%s%d%s\00", align 1

define void @main() {
entry:
	%0 = alloca i32
	%1 = alloca [11 x i32]
	store i32 0, i32* %0
	br label %entry1
entry1:
	%2 = load i32, i32* %0
	%3 = sub i32 11, %2
	%4 = icmp ne i32 %3, 0
	br i1 %4, label %do2, label %done3
do2:
	%5 = load i32, i32* %0
	%6 = getelementptr inbounds [11 x i32], [11 x i32]* %1, i32 0, i32 %5
	%7 = load i32, i32* %0
	%8 = call i32 @fact(i32 %7)
	store i32 %8, i32* %6
	%9 = load i32, i32* %0
	%10 = add i32 %9, 1
	store i32 %10, i32* %0
	br label %entry1
done3:
	store i32 0, i32* %0
	br label %entry4
entry4:
	%11 = load i32, i32* %0
	%12 = sub i32 11, %11
	%13 = icmp ne i32 %12, 0
	br i1 %13, label %do5, label %done6
do5:
	%14 = getelementptr inbounds [3 x i8], [3 x i8]* @.str1, i32 0, i32 0
	%15 = load i32, i32* %0
	%16 = getelementptr inbounds [5 x i8], [5 x i8]* @.str2, i32 0, i32 0
	%17 = load i32, i32* %0
	%18 = getelementptr inbounds [11 x i32], [11 x i32]* %1, i32 0, i32 %17
	%19 = load i32, i32* %18
	%20 = getelementptr inbounds [2 x i8], [2 x i8]* @.str3, i32 0, i32 0
	%21 = getelementptr inbounds [11 x i8], [11 x i8]* @.str4, i32 0, i32 0
	%22 = call i32 (i8*, ...) @printf(i8* %21, i8* %14, i32 %15, i8* %16, i32 %19, i8* %20)
	%23 = load i32, i32* %0
	%24 = add i32 %23, 1
	store i32 %24, i32* %0
	br label %entry4
done6:
	ret void 
}

define i32 @fact(i32) {
entry:
	%1 = alloca i32
	store i32 %0, i32* %1
	%2 = alloca i32
	%3 = alloca i32
	%4 = load i32, i32* %1
	%5 = icmp ne i32 %4, 0
	br i1 %5, label %then7, label %else8
then7:
	%6 = load i32, i32* %1
	%7 = load i32, i32* %1
	%8 = sub i32 %7, 1
	%9 = call i32 @fact(i32 %8)
	%10 = mul i32 %6, %9
	store i32 %10, i32* %3
	br label %fi9
else8:
	store i32 1, i32* %3
	br label %fi9
fi9:
	%11 = load i32, i32* %3
	store i32 %11, i32* %2
	%12 = load i32, i32* %2
	ret i32 %12
}


