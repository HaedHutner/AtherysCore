package com.atherys.core.template;

import org.spongepowered.api.text.Text;

public class TextTemplate extends AbstractTemplate<Text> {

    protected Text template = Text.EMPTY;

    protected void setTemplate(Text template) {
        this.template = template;
    }

    @Override
    public Text render() {
        return applyAttributesTo(template);
    }
}
