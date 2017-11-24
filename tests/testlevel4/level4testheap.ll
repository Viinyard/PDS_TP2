; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [12 x i8]c"\0A Entrer le\00", align 1
@.str2 = private unnamed_addr constant [7 x i8]c"eme:  \00", align 1
@.str7 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str8 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str3 = private unnamed_addr constant [6 x i8]c"   i=\00", align 1
@.str4 = private unnamed_addr constant [5 x i8]c"  j=\00", align 1
@.str9 = private unnamed_addr constant [9 x i8]c"%s%d%s%d\00", align 1
@.str5 = private unnamed_addr constant [5 x i8]c"\0A t[\00", align 1
@.str6 = private unnamed_addr constant [5 x i8]c"] = \00", align 1
@.str10 = private unnamed_addr constant [9 x i8]c"%s%d%s%d\00", align 1

define void @main() {
entry:
	%0 = alloca [10 x i32]
	%1 = alloca i32
	%2 = alloca i32
	store i32 0, i32* %1
	br label %entry1
entry1:
	%3 = load i32, i32* %1
	%4 = sub i32 10, %3
	%5 = icmp ne i32 %4, 0
	br i1 %5, label %do2, label %done3
do2:
	%6 = getelementptr inbounds [12 x i8], [12 x i8]* @.str1, i32 0, i32 0
	%7 = load i32, i32* %1
	%8 = getelementptr inbounds [7 x i8], [7 x i8]* @.str2, i32 0, i32 0
	%9 = getelementptr inbounds [7 x i8], [7 x i8]* @.str7, i32 0, i32 0
	%10 = call i32 (i8*, ...) @printf(i8* %9, i8* %6, i32 %7, i8* %8)
	%11 = getelementptr inbounds [3 x i8], [3 x i8]* @.str8, i32 0, i32 0
	%12 = call i32 (i8*, ...) @scanf(i8* %11, i32* %2)
	%13 = load i32, i32* %1
	%14 = getelementptr inbounds [10 x i32], [10 x i32]* %0, i32 0, i32 %13
	%15 = load i32, i32* %2
	store i32 %15, i32* %14
	%16 = load i32, i32* %1
	%17 = add i32 %16, 1
	store i32 %17, i32* %1
	%18 = getelementptr inbounds [6 x i8], [6 x i8]* @.str3, i32 0, i32 0
	%19 = load i32, i32* %1
	%20 = getelementptr inbounds [5 x i8], [5 x i8]* @.str4, i32 0, i32 0
	%21 = load i32, i32* %2
	%22 = getelementptr inbounds [9 x i8], [9 x i8]* @.str9, i32 0, i32 0
	%23 = call i32 (i8*, ...) @printf(i8* %22, i8* %18, i32 %19, i8* %20, i32 %21)
	br label %entry1
done3:
	%24 = getelementptr inbounds [10 x i32], [10 x i32]* %0, i32 0, i32 0
	call void @heapsort(i32* %24, i32 10)
	store i32 0, i32* %1
	br label %entry4
entry4:
	%25 = load i32, i32* %1
	%26 = sub i32 10, %25
	%27 = icmp ne i32 %26, 0
	br i1 %27, label %do5, label %done6
do5:
	%28 = getelementptr inbounds [5 x i8], [5 x i8]* @.str5, i32 0, i32 0
	%29 = load i32, i32* %1
	%30 = getelementptr inbounds [5 x i8], [5 x i8]* @.str6, i32 0, i32 0
	%31 = load i32, i32* %1
	%32 = getelementptr inbounds [10 x i32], [10 x i32]* %0, i32 0, i32 %31
	%33 = load i32, i32* %32
	%34 = getelementptr inbounds [9 x i8], [9 x i8]* @.str10, i32 0, i32 0
	%35 = call i32 (i8*, ...) @printf(i8* %34, i8* %28, i32 %29, i8* %30, i32 %33)
	%36 = load i32, i32* %1
	%37 = add i32 %36, 1
	store i32 %37, i32* %1
	br label %entry4
done6:
	ret void 
}

define void @heapsort(i32*, i32) {
entry:
	%2 = alloca i32*
	%3 = alloca i32
	store i32* %0, i32** %2
	store i32 %1, i32* %3
	%4 = alloca i32
	%5 = alloca i32
	%6 = alloca i32
	%7 = alloca i32
	%8 = alloca i32
	%9 = load i32, i32* %3
	%10 = udiv i32 %9, 2
	%11 = add i32 %10, 1
	store i32 %11, i32* %4
	%12 = load i32, i32* %3
	store i32 %12, i32* %5
	br label %entry7
entry7:
	%13 = load i32, i32* %5
	%14 = call i32 @plusgrand(i32 %13, i32 2)
	%15 = icmp ne i32 %14, 0
	br i1 %15, label %do8, label %done9
do8:
	%16 = load i32, i32* %4
	%17 = call i32 @plusgrandstrict(i32 %16, i32 1)
	%18 = icmp ne i32 %17, 0
	br i1 %18, label %then10, label %else11
then10:
	%19 = load i32, i32* %4
	%20 = sub i32 %19, 1
	store i32 %20, i32* %4
	%21 = load i32, i32* %4
	store i32 %21, i32* %6
	br label %fi12
else11:
	%22 = alloca i32
	%23 = load i32*, i32** %2
	%24 = getelementptr inbounds i32, i32* %23, i32 0
	%25 = load i32, i32* %24
	store i32 %25, i32* %22
	%26 = load i32*, i32** %2
	%27 = getelementptr inbounds i32, i32* %26, i32 0
	%28 = load i32, i32* %5
	%29 = sub i32 %28, 1
	%30 = load i32*, i32** %2
	%31 = getelementptr inbounds i32, i32* %30, i32 %29
	%32 = load i32, i32* %31
	store i32 %32, i32* %27
	%33 = load i32, i32* %5
	%34 = sub i32 %33, 1
	%35 = load i32*, i32** %2
	%36 = getelementptr inbounds i32, i32* %35, i32 %34
	%37 = load i32, i32* %22
	store i32 %37, i32* %36
	%38 = load i32, i32* %5
	%39 = sub i32 %38, 1
	store i32 %39, i32* %5
	store i32 1, i32* %6
	br label %fi12
fi12:
	%40 = load i32, i32* %6
	%41 = sub i32 %40, 1
	%42 = load i32*, i32** %2
	%43 = getelementptr inbounds i32, i32* %42, i32 %41
	%44 = load i32, i32* %43
	store i32 %44, i32* %7
	%45 = load i32, i32* %5
	%46 = load i32, i32* %6
	%47 = mul i32 2, %46
	%48 = call i32 @plusgrand(i32 %45, i32 %47)
	store i32 %48, i32* %8
	br label %entry13
entry13:
	%49 = load i32, i32* %8
	%50 = icmp ne i32 %49, 0
	br i1 %50, label %do14, label %done15
do14:
	%51 = alloca i32
	%52 = load i32, i32* %6
	%53 = mul i32 2, %52
	store i32 %53, i32* %51
	%54 = load i32, i32* %5
	%55 = load i32, i32* %51
	%56 = call i32 @plusgrandstrict(i32 %54, i32 %55)
	%57 = load i32, i32* %51
	%58 = load i32*, i32** %2
	%59 = getelementptr inbounds i32, i32* %58, i32 %57
	%60 = load i32, i32* %59
	%61 = load i32, i32* %51
	%62 = sub i32 %61, 1
	%63 = load i32*, i32** %2
	%64 = getelementptr inbounds i32, i32* %63, i32 %62
	%65 = load i32, i32* %64
	%66 = call i32 @plusgrandstrict(i32 %60, i32 %65)
	%67 = mul i32 %56, %66
	%68 = icmp ne i32 %67, 0
	br i1 %68, label %then16, label %fi17
then16:
	%69 = load i32, i32* %51
	%70 = add i32 %69, 1
	store i32 %70, i32* %51
	br label %fi17
fi17:
	%71 = load i32, i32* %51
	%72 = sub i32 %71, 1
	%73 = load i32*, i32** %2
	%74 = getelementptr inbounds i32, i32* %73, i32 %72
	%75 = load i32, i32* %74
	%76 = load i32, i32* %7
	%77 = call i32 @plusgrandstrict(i32 %75, i32 %76)
	%78 = icmp ne i32 %77, 0
	br i1 %78, label %then18, label %else19
then18:
	%79 = load i32, i32* %6
	%80 = sub i32 %79, 1
	%81 = load i32*, i32** %2
	%82 = getelementptr inbounds i32, i32* %81, i32 %80
	%83 = load i32, i32* %51
	%84 = sub i32 %83, 1
	%85 = load i32*, i32** %2
	%86 = getelementptr inbounds i32, i32* %85, i32 %84
	%87 = load i32, i32* %86
	store i32 %87, i32* %82
	%88 = load i32, i32* %51
	store i32 %88, i32* %6
	%89 = load i32, i32* %5
	%90 = load i32, i32* %6
	%91 = mul i32 2, %90
	%92 = call i32 @plusgrand(i32 %89, i32 %91)
	store i32 %92, i32* %8
	br label %fi20
else19:
	store i32 0, i32* %8
	br label %fi20
fi20:
	br label %entry13
done15:
	%93 = load i32, i32* %6
	%94 = sub i32 %93, 1
	%95 = load i32*, i32** %2
	%96 = getelementptr inbounds i32, i32* %95, i32 %94
	%97 = load i32, i32* %7
	store i32 %97, i32* %96
	br label %entry7
done9:
	ret void 
}

define i32 @plusgrandstrict(i32, i32) {
entry:
	%2 = alloca i32
	%3 = alloca i32
	store i32 %1, i32* %2
	store i32 %0, i32* %3
	%4 = alloca i32
	%5 = alloca i32
	%6 = alloca i32
	%7 = alloca i32
	%8 = load i32, i32* %3
	%9 = load i32, i32* %2
	%10 = mul i32 %8, %9
	store i32 %10, i32* %5
	%11 = load i32, i32* %3
	store i32 %11, i32* %6
	%12 = load i32, i32* %2
	store i32 %12, i32* %7
	br label %entry21
entry21:
	%13 = load i32, i32* %5
	%14 = icmp ne i32 %13, 0
	br i1 %14, label %do22, label %done23
do22:
	%15 = load i32, i32* %7
	%16 = sub i32 %15, 1
	store i32 %16, i32* %7
	%17 = load i32, i32* %6
	%18 = sub i32 %17, 1
	store i32 %18, i32* %6
	%19 = load i32, i32* %6
	%20 = load i32, i32* %7
	%21 = mul i32 %19, %20
	store i32 %21, i32* %5
	br label %entry21
done23:
	%22 = load i32, i32* %6
	%23 = icmp ne i32 %22, 0
	br i1 %23, label %then24, label %else25
then24:
	store i32 1, i32* %4
	br label %fi26
else25:
	store i32 0, i32* %4
	br label %fi26
fi26:
	%24 = load i32, i32* %4
	ret i32 %24
}

define i32 @plusgrand(i32, i32) {
entry:
	%2 = alloca i32
	%3 = alloca i32
	store i32 %1, i32* %2
	store i32 %0, i32* %3
	%4 = alloca i32
	%5 = alloca i32
	%6 = alloca i32
	%7 = alloca i32
	%8 = load i32, i32* %3
	%9 = load i32, i32* %2
	%10 = mul i32 %8, %9
	store i32 %10, i32* %5
	%11 = load i32, i32* %3
	store i32 %11, i32* %6
	%12 = load i32, i32* %2
	store i32 %12, i32* %7
	br label %entry27
entry27:
	%13 = load i32, i32* %5
	%14 = icmp ne i32 %13, 0
	br i1 %14, label %do28, label %done29
do28:
	%15 = load i32, i32* %7
	%16 = sub i32 %15, 1
	store i32 %16, i32* %7
	%17 = load i32, i32* %6
	%18 = sub i32 %17, 1
	store i32 %18, i32* %6
	%19 = load i32, i32* %6
	%20 = load i32, i32* %7
	%21 = mul i32 %19, %20
	store i32 %21, i32* %5
	br label %entry27
done29:
	%22 = load i32, i32* %6
	%23 = icmp ne i32 %22, 0
	br i1 %23, label %then30, label %else31
then30:
	store i32 1, i32* %4
	br label %fi32
else31:
	%24 = load i32, i32* %7
	%25 = icmp ne i32 %24, 0
	br i1 %25, label %then33, label %else34
then33:
	store i32 0, i32* %4
	br label %fi35
else34:
	store i32 1, i32* %4
	br label %fi35
fi35:
	br label %fi32
fi32:
	%26 = load i32, i32* %4
	ret i32 %26
}


