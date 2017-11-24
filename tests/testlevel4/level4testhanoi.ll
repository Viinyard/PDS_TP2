; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [14 x i8]c"\0A Hanoi avec \00", align 1
@.str2 = private unnamed_addr constant [11 x i8]c" disques\0A\0A\00", align 1
@.str8 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str3 = private unnamed_addr constant [14 x i8]c"\0A\0AHanoi avec \00", align 1
@.str4 = private unnamed_addr constant [11 x i8]c" disques\0A\0A\00", align 1
@.str9 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str5 = private unnamed_addr constant [23 x i8]c"Deplacer un disque de \00", align 1
@.str6 = private unnamed_addr constant [4 x i8]c" a \00", align 1
@.str7 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str10 = private unnamed_addr constant [11 x i8]c"%s%d%s%d%s\00", align 1

define void @main() {
entry:
	%0 = alloca i32
	%1 = alloca i32
	store i32 3, i32* %0
	%2 = getelementptr inbounds [14 x i8], [14 x i8]* @.str1, i32 0, i32 0
	%3 = load i32, i32* %0
	%4 = getelementptr inbounds [11 x i8], [11 x i8]* @.str2, i32 0, i32 0
	%5 = getelementptr inbounds [7 x i8], [7 x i8]* @.str8, i32 0, i32 0
	%6 = call i32 (i8*, ...) @printf(i8* %5, i8* %2, i32 %3, i8* %4)
	%7 = load i32, i32* %0
	%8 = call i32 @hanoi(i32 %7, i32 1, i32 3, i32 2)
	store i32 %8, i32* %1
	store i32 4, i32* %0
	%9 = getelementptr inbounds [14 x i8], [14 x i8]* @.str3, i32 0, i32 0
	%10 = load i32, i32* %0
	%11 = getelementptr inbounds [11 x i8], [11 x i8]* @.str4, i32 0, i32 0
	%12 = getelementptr inbounds [7 x i8], [7 x i8]* @.str9, i32 0, i32 0
	%13 = call i32 (i8*, ...) @printf(i8* %12, i8* %9, i32 %10, i8* %11)
	%14 = load i32, i32* %0
	%15 = call i32 @hanoi(i32 %14, i32 1, i32 3, i32 2)
	store i32 %15, i32* %1
	ret void 
}

define i32 @hanoi(i32, i32, i32, i32) {
entry:
	%4 = alloca i32
	%5 = alloca i32
	%6 = alloca i32
	%7 = alloca i32
	store i32 %2, i32* %4
	store i32 %1, i32* %5
	store i32 %0, i32* %6
	store i32 %3, i32* %7
	%8 = alloca i32
	%9 = alloca i32
	%10 = load i32, i32* %6
	%11 = icmp ne i32 %10, 0
	br i1 %11, label %then1, label %fi2
then1:
	%12 = load i32, i32* %6
	%13 = sub i32 %12, 1
	%14 = load i32, i32* %5
	%15 = load i32, i32* %7
	%16 = load i32, i32* %4
	%17 = call i32 @hanoi(i32 %13, i32 %14, i32 %15, i32 %16)
	store i32 %17, i32* %9
	%18 = getelementptr inbounds [23 x i8], [23 x i8]* @.str5, i32 0, i32 0
	%19 = load i32, i32* %5
	%20 = getelementptr inbounds [4 x i8], [4 x i8]* @.str6, i32 0, i32 0
	%21 = load i32, i32* %4
	%22 = getelementptr inbounds [2 x i8], [2 x i8]* @.str7, i32 0, i32 0
	%23 = getelementptr inbounds [11 x i8], [11 x i8]* @.str10, i32 0, i32 0
	%24 = call i32 (i8*, ...) @printf(i8* %23, i8* %18, i32 %19, i8* %20, i32 %21, i8* %22)
	%25 = load i32, i32* %6
	%26 = sub i32 %25, 1
	%27 = load i32, i32* %7
	%28 = load i32, i32* %4
	%29 = load i32, i32* %5
	%30 = call i32 @hanoi(i32 %26, i32 %27, i32 %28, i32 %29)
	store i32 %30, i32* %9
	br label %fi2
fi2:
	store i32 1, i32* %8
	%31 = load i32, i32* %8
	ret i32 %31
}


