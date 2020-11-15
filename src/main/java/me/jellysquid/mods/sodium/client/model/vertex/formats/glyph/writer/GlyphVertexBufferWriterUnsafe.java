package me.jellysquid.mods.sodium.client.model.vertex.formats.glyph.writer;

import me.jellysquid.mods.sodium.client.model.vertex.buffer.VertexBufferView;
import me.jellysquid.mods.sodium.client.model.vertex.buffer.VertexBufferWriterUnsafe;
import me.jellysquid.mods.sodium.client.model.vertex.formats.glyph.GlyphVertexSink;

public class GlyphVertexBufferWriterUnsafe extends VertexBufferWriterUnsafe implements GlyphVertexSink {
    public GlyphVertexBufferWriterUnsafe(VertexBufferView backingBuffer) {
        super(backingBuffer, GlyphVertexSink.VERTEX_FORMAT);
    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    public void writeGlyph(float x, float y, float z, int color, float u, float v, int light) {
        long i = this.writePointer;

        UNSAFE.putFloat(i, x);
        UNSAFE.putFloat(i + 4, y);
        UNSAFE.putFloat(i + 8, z);
        UNSAFE.putFloat(i + 12, u);
        UNSAFE.putFloat(i + 16, v);
        UNSAFE.putInt(i + 20, light);
        UNSAFE.putInt(i + 24, color);

        this.advance();

    }
}
