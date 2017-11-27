; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [12 x i8]c"\0A Entrer le\00", align 1
@.str2 = private unnamed_addr constant [7 x i8]c"eme:  \00", align 1
@.str3 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str4 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str5 = private unnamed_addr constant [6 x i8]c"   i=\00", align 1
@.str6 = private unnamed_addr constant [5 x i8]c"  j=\00", align 1
@.str7 = private unnamed_addr constant [9 x i8]c"%s%d%s%d\00", align 1
@.str8 = private unnamed_addr constant [5 x i8]c"\0A t[\00", align 1
@.str9 = private unnamed_addr constant [5 x i8]c"] = \00", align 1
@.str10 = private unnamed_addr constant [9 x i8]c"%s%d%s%d\00", align 1

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
	br i1 %7, label %8, label %27
; <label>:8
	%9 = getelementptr inbounds [12 x i8], [12 x i8]* @.str1, i32 0, i32 0
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
	%21 = getelementptr inbounds [6 x i8], [6 x i8]* @.str5, i32 0, i32 0
	%22 = load i32, i32* %2
	%23 = getelementptr inbounds [5 x i8], [5 x i8]* @.str6, i32 0, i32 0
	%24 = load i32, i32* %3
	%25 = getelementptr inbounds [9 x i8], [9 x i8]* @.str7, i32 0, i32 0
	%26 = call i32 (i8*, ...) @printf(i8* %25, i8* %21, i32 %22, i8* %23, i32 %24)
	br label %4
; <label>:27
	%28 = getelementptr inbounds [10 x i32], [10 x i32]* %1, i32 0, i32 0
	call void @heapsort(i32* %28, i32 10)
	store i32 0, i32* %2
	br label %29
; <label>:29
	%30 = load i32, i32* %2
	%31 = sub i32 10, %30
	%32 = icmp ne i32 %31, 0
	br i1 %32, label %33, label %44
; <label>:33
	%34 = getelementptr inbounds [5 x i8], [5 x i8]* @.str8, i32 0, i32 0
	%35 = load i32, i32* %2
	%36 = getelementptr inbounds [5 x i8], [5 x i8]* @.str9, i32 0, i32 0
	%37 = load i32, i32* %2
	%38 = getelementptr inbounds [10 x i32], [10 x i32]* %1, i32 0, i32 %37
	%39 = load i32, i32* %38
	%40 = getelementptr inbounds [9 x i8], [9 x i8]* @.str10, i32 0, i32 0
	%41 = call i32 (i8*, ...) @printf(i8* %40, i8* %34, i32 %35, i8* %36, i32 %39)
	%42 = load i32, i32* %2
	%43 = add i32 %42, 1
	store i32 %43, i32* %2
	br label %29
; <label>:44
	ret void 
}

define void @heapsort(i32*, i32) {
; <label>:2
	%3 = alloca i32*
	%4 = alloca i32
	%5 = alloca i32
	%6 = alloca i32
	%7 = alloca i32
	%8 = alloca i32
	%9 = alloca i32
	%10 = alloca i32
	%11 = alloca i32
	store i32* %0, i32** %3
	store i32 %1, i32* %4
	%12 = load i32, i32* %4
	%13 = udiv i32 %12, 2
	%14 = add i32 %13, 1
	store i32 %14, i32* %5
	%15 = load i32, i32* %4
	store i32 %15, i32* %6
	br label %16
; <label>:16
	%17 = load i32, i32* %6
	%18 = call i32 @plusgrand(i32 %17, i32 2)
	%19 = icmp ne i32 %18, 0
	br i1 %19, label %20, label %112
; <label>:20
	%21 = load i32, i32* %5
	%22 = call i32 @plusgrandstrict(i32 %21, i32 1)
	%23 = icmp ne i32 %22, 0
	br i1 %23, label %24, label %28
; <label>:24
	%25 = load i32, i32* %5
	%26 = sub i32 %25, 1
	store i32 %26, i32* %5
	%27 = load i32, i32* %5
	store i32 %27, i32* %7
	br label %46
; <label>:28
	%29 = load i32*, i32** %3
	%30 = getelementptr inbounds i32, i32* %29, i32 0
	%31 = load i32, i32* %30
	store i32 %31, i32* %10
	%32 = load i32, i32* %6
	%33 = sub i32 %32, 1
	%34 = load i32*, i32** %3
	%35 = getelementptr inbounds i32, i32* %34, i32 %33
	%36 = load i32, i32* %35
	%37 = load i32*, i32** %3
	%38 = getelementptr inbounds i32, i32* %37, i32 0
	store i32 %36, i32* %38
	%39 = load i32, i32* %10
	%40 = load i32, i32* %6
	%41 = sub i32 %40, 1
	%42 = load i32*, i32** %3
	%43 = getelementptr inbounds i32, i32* %42, i32 %41
	store i32 %39, i32* %43
	%44 = load i32, i32* %6
	%45 = sub i32 %44, 1
	store i32 %45, i32* %6
	store i32 1, i32* %7
	br label %46
; <label>:46
	%47 = load i32, i32* %7
	%48 = sub i32 %47, 1
	%49 = load i32*, i32** %3
	%50 = getelementptr inbounds i32, i32* %49, i32 %48
	%51 = load i32, i32* %50
	store i32 %51, i32* %8
	%52 = load i32, i32* %6
	%53 = load i32, i32* %7
	%54 = mul i32 2, %53
	%55 = call i32 @plusgrand(i32 %52, i32 %54)
	store i32 %55, i32* %9
	br label %56
; <label>:56
	%57 = load i32, i32* %9
	%58 = icmp ne i32 %57, 0
	br i1 %58, label %59, label %106
; <label>:59
	%60 = load i32, i32* %7
	%61 = mul i32 2, %60
	store i32 %61, i32* %11
	%62 = load i32, i32* %6
	%63 = load i32, i32* %11
	%64 = call i32 @plusgrandstrict(i32 %62, i32 %63)
	%65 = load i32, i32* %11
	%66 = load i32*, i32** %3
	%67 = getelementptr inbounds i32, i32* %66, i32 %65
	%68 = load i32, i32* %67
	%69 = load i32, i32* %11
	%70 = sub i32 %69, 1
	%71 = load i32*, i32** %3
	%72 = getelementptr inbounds i32, i32* %71, i32 %70
	%73 = load i32, i32* %72
	%74 = call i32 @plusgrandstrict(i32 %68, i32 %73)
	%75 = mul i32 %64, %74
	%76 = icmp ne i32 %75, 0
	br i1 %76, label %77, label %80
; <label>:77
	%78 = load i32, i32* %11
	%79 = add i32 %78, 1
	store i32 %79, i32* %11
	br label %80
; <label>:80
	%81 = load i32, i32* %11
	%82 = sub i32 %81, 1
	%83 = load i32*, i32** %3
	%84 = getelementptr inbounds i32, i32* %83, i32 %82
	%85 = load i32, i32* %84
	%86 = load i32, i32* %8
	%87 = call i32 @plusgrandstrict(i32 %85, i32 %86)
	%88 = icmp ne i32 %87, 0
	br i1 %88, label %89, label %104
; <label>:89
	%90 = load i32, i32* %11
	%91 = sub i32 %90, 1
	%92 = load i32*, i32** %3
	%93 = getelementptr inbounds i32, i32* %92, i32 %91
	%94 = load i32, i32* %93
	%95 = load i32, i32* %7
	%96 = sub i32 %95, 1
	%97 = load i32*, i32** %3
	%98 = getelementptr inbounds i32, i32* %97, i32 %96
	store i32 %94, i32* %98
	%99 = load i32, i32* %11
	store i32 %99, i32* %7
	%100 = load i32, i32* %6
	%101 = load i32, i32* %7
	%102 = mul i32 2, %101
	%103 = call i32 @plusgrand(i32 %100, i32 %102)
	store i32 %103, i32* %9
	br label %105
; <label>:104
	store i32 0, i32* %9
	br label %105
; <label>:105
	br label %56
; <label>:106
	%107 = load i32, i32* %8
	%108 = load i32, i32* %7
	%109 = sub i32 %108, 1
	%110 = load i32*, i32** %3
	%111 = getelementptr inbounds i32, i32* %110, i32 %109
	store i32 %107, i32* %111
	br label %16
; <label>:112
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

define i32 @plusgrand(i32, i32) {
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
	br label %35
; <label>:29
	%30 = load i32, i32* %8
	%31 = icmp ne i32 %30, 0
	br i1 %31, label %32, label %33
; <label>:32
	store i32 0, i32* %5
	br label %34
; <label>:33
	store i32 1, i32* %5
	br label %34
; <label>:34
	br label %35
; <label>:35
	%36 = load i32, i32* %5
	ret i32 %36
}


