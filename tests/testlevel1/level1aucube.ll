; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i64 @main() {
	%x =  alloca i64
	store i64 2, i64* %x
	%tmp1 = load i64, i64* %x
	%tmp2 = load i64, i64* %x
	%tmp3 = mul i64 %tmp1, %tmp2
	store i64 %tmp3, i64* %x
	%tmp4 = load i64, i64* %x
	%tmp5 = load i64, i64* %x
	%tmp6 = mul i64 %tmp4, %tmp5
	store i64 %tmp6, i64* %x
	%tmp7 = load i64, i64* %x
	%tmp8 = mul i64 %tmp7, 2
	store i64 %tmp8, i64* %x
	ret i64 256
}


