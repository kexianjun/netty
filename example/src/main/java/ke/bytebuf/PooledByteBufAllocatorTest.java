package ke.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.util.ReferenceCountUtil;

/**
 * @date 2020/10/19 10:10 上午
 */
public class PooledByteBufAllocatorTest {
    public static void main(String[] args) {
        PooledByteBufAllocator allocator = PooledByteBufAllocator.DEFAULT;
        ByteBuf buffer = allocator.directBuffer(1024);
        String str = "hello";
        buffer.writeBytes(str.getBytes());
        byte[] bytes = new byte[buffer.readableBytes()];
        buffer.readBytes(bytes);
        System.out.println(new String(bytes));
        int i = ReferenceCountUtil.refCnt(buffer);
        System.out.println("before release count :" + i);
        buffer.release();
        i = ReferenceCountUtil.refCnt(buffer);
        System.out.println("after release count :" + i);
    }
}
