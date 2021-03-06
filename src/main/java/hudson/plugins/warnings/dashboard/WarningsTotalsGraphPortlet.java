package hudson.plugins.warnings.dashboard;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.plugins.analysis.graph.BuildResultGraph;
import hudson.plugins.analysis.graph.TotalsGraph;
import hudson.plugins.view.dashboard.DashboardPortlet;
import hudson.plugins.warnings.Messages;

import org.kohsuke.stapler.DataBoundConstructor;

/**
 * A portlet that shows the warnings trend graph by priority.
 *
 * @author Ulli Hafner
 */
public final class WarningsTotalsGraphPortlet extends AbstractTrendPortlet {
    /**
     * Creates a new instance of {@link WarningsTotalsGraphPortlet}.
     *
     * @param name
     *            the name of the portlet
     * @param width
     *            width of the graph
     * @param height
     *            height of the graph
     * @param dayCountString
     *            number of days to consider
     * @param parserName
     *            the name of the parser
     */
    @DataBoundConstructor
    public WarningsTotalsGraphPortlet(final String name, final String width, final String height,
            final String dayCountString, final String parserName) {
        super(name, width, height, dayCountString, parserName);

        configureGraph(getGraphType());
    }

    @Override
    protected BuildResultGraph getGraphType() {
        return new TotalsGraph();
    }

    /**
     * Extension point registration.
     *
     * @author Ulli Hafner
     */
    @Extension(optional = true)
    public static class WarningsGraphDescriptor extends Descriptor<DashboardPortlet> {
        @Override
        public String getDisplayName() {
            return Messages.Portlet_WarningsTotalsGraph();
        }
    }
}

