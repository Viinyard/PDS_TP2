; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [13 x i8]c"\0A Entrer le \00", align 1
@.str2 = private unnamed_addr constant [7 x i8]c"eme:  \00", align 1
@.str3 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str4 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str5 = private unnamed_addr constant [5 x i8]c"\0A t[\00", align 1
@.str6 = private unnamed_addr constant [5 x i8]c"] = \00", align 1
@.str7 = private unnamed_addr constant [9 x i8]c"%s%d%s%d\00", align 1

define void @main() {
; <label>:0
	%1 = alloca [10 x i32]
	%2 = alloca i32
	%3 = alloca i32
	store i32 0, i32* %2
	br label %4
; <label>:4
	%5 = load i32, i32* %2
	%6 = sub i32 10, %5
	%7 = icmp ne i32 %6, 0
	br i1 %7, label %8, label %21
; <label>:8
	%9 = getelementptr inbounds [13 x i8], [13 x i8]* @.str1, i32 0, i32 0
	%10 = load i32, i32* %2
	%11 = getelementptr inbounds [7 x i8], [7 x i8]* @.str2, i32 0, i32 0
	%12 = getelementptr inbounds [7 x i8], [7 x i8]* @.str3, i32 0, i32 0
	%13 = call i32 (i8*, ...) @printf(i8* %12, i8* %9, i32 %10, i8* %11)
	%14 = getelementptr inbounds [3 x i8], [3 x i8]* @.str4, i32 0, i32 0
	%15 = call i32 (i8*, ...) @scanf(i8* %14, i32* %3)
	%16 = load i32, i32* %3
	%17 = load i32, i32* %2
	%18 = getelementptr inbounds [10 x i32], [10 x i32]* %1, i32 0, i32 %17
	store i32 %16, i32* %18
	%19 = load i32, i32* %2
	%20 = add i32 %19, 1
	store i32 %20, i32* %2
	br label %4
; <label>:21
	%22 = getelementptr inbounds [10 x i32], [10 x i32]* %1, i32 0, i32 0
	call void @naivesort(i32* %22, i32 9)
	store i32 0, i32* %2
	br label %23
; <label>:23
	%24 = load i32, i32* %2
	%25 = sub i32 10, %24
	%26 = icmp ne i32 %25, 0
	br i1 %26, label %27, label %38
; <label>:27
	%28 = getelementptr inbounds [5 x i8], [5 x i8]* @.str5, i32 0, i32 0
	%29 = load i32, i32* %2
	%30 = getelementptr inbounds [5 x i8], [5 x i8]* @.str6, i32 0, i32 0
	%31 = load i32, i32* %2
	%32 = getelementptr inbounds [10 x i32], [10 x i32]* %1, i32 0, i32 %31
	%33 = load i32, i32* %32
	%34 = getelementptr inbounds [9 x i8], [9 x i8]* @.str7, i32 0, i32 0
	%35 = call i32 (i8*, ...) @printf(i8* %34, i8* %28, i32 %29, i8* %30, i32 %33)
	%36 = load i32, i32* %2
	%37 = add i32 %36, 1
	store i32 %37, i32* %2
	br label %23
; <label>:38
	ret void 
}

define void @naivesort(i32*, i32) {
; <label>:2
	%3 = alloca i32*
	%4 = alloca i32
	%5 = alloca i32
	%6 = alloca i32
	%7 = alloca i32
	store i32* %0, i32** %3
	store i32 %1, i32* %4
	%8 = load i32, i32* %4
	%9 = icmp ne i32 %8, 0
	br i1 %9, label %10, label %53
; <label>:10
	%11 = load i32, i32* %4
	%12 = load i32*, i32** %3
	%13 = getelementptr inbounds i32, i32* %12, i32 %11
	%14 = load i32, i32* %13
	store i32 %14, i32* %5
	%15 = load i32, i32* %4
	store i32 %15, i32* %7
	%16 = load i32, i32* %4
	store i32 %16, i32* %6
	br label %17
; <label>:17
	%18 = load i32, i32* %7
	%19 = add i32 %18, 1
	%20 = icmp ne i32 %19, 0
	br i1 %20, label %21, label %38
; <label>:21
	%22 = load i32, i32* %7
	%23 = load i32*, i32** %3
	%24 = getelementptr inbounds i32, i32* %23, i32 %22
	%25 = load i32, i32* %24
	%26 = load i32, i32* %5
	%27 = call i32 @plusgrandstrict(i32 %25, i32 %26)
	%28 = icmp ne i32 %27, 0
	br i1 %28, label %29, label %35
; <label>:29
	%30 = load i32, i32* %7
	%31 = load i32*, i32** %3
	%32 = getelementptr inbounds i32, i32* %31, i32 %30
	%33 = load i32, i32* %32
	store i32 %33, i32* %5
	%34 = load i32, i32* %7
	store i32 %34, i32* %6
	br label %35
; <label>:35
	%36 = load i32, i32* %7
	%37 = sub i32 %36, 1
	store i32 %37, i32* %7
	br label %17
; <label>:38
	%39 = load i32, i32* %4
	%40 = load i32*, i32** %3
	%41 = getelementptr inbounds i32, i32* %40, i32 %39
	%42 = load i32, i32* %41
	%43 = load i32, i32* %6
	%44 = load i32*, i32** %3
	%45 = getelementptr inbounds i32, i32* %44, i32 %43
	store i32 %42, i32* %45
	%46 = load i32, i32* %5
	%47 = load i32, i32* %4
	%48 = load i32*, i32** %3
	%49 = getelementptr inbounds i32, i32* %48, i32 %47
	store i32 %46, i32* %49
	%50 = load i32*, i32** %3
	%51 = load i32, i32* %4
	%52 = sub i32 %51, 1
	call void @naivesort(i32* %50, i32 %52)
	br label %53
; <label>:53
	ret void 
}

define i32 @plusgrandstrict(i32, i32) {
; <label>:2
	%3 = alloca i32
	%4 = alloca i32
	%5 = alloca i32
	%6 = alloca i32
	%7 = alloca i32
	%8 = alloca i32
	store i32 %0, i32* %3
	store i32 %1, i32* %4
	%9 = load i32, i32* %3
	%10 = load i32, i32* %4
	%11 = mul i32 %9, %10
	store i32 %11, i32* %6
	%12 = load i32, i32* %3
	store i32 %12, i32* %7
	%13 = load i32, i32* %4
	store i32 %13, i32* %8
	br label %14
; <label>:14
	%15 = load i32, i32* %6
	%16 = icmp ne i32 %15, 0
	br i1 %16, label %17, label %25
; <label>:17
	%18 = load i32, i32* %8
	%19 = sub i32 %18, 1
	store i32 %19, i32* %8
	%20 = load i32, i32* %7
	%21 = sub i32 %20, 1
	store i32 %21, i32* %7
	%22 = load i32, i32* %7
	%23 = load i32, i32* %8
	%24 = mul i32 %22, %23
	store i32 %24, i32* %6
	br label %14
; <label>:25
	%26 = load i32, i32* %7
	%27 = icmp ne i32 %26, 0
	br i1 %27, label %28, label %29
; <label>:28
	store i32 1, i32* %5
	br label %30
; <label>:29
	store i32 0, i32* %5
	br label %30
; <label>:30
	%31 = load i32, i32* %5
	ret i32 %31
}


