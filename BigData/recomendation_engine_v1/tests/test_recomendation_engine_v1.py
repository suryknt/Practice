#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""Tests for `recomendation_engine_v1` package."""


import unittest
from click.testing import CliRunner

from recomendation_engine_v1 import recomendation_engine_v1
from recomendation_engine_v1 import cli


class TestRecomendation_engine_v1(unittest.TestCase):
    """Tests for `recomendation_engine_v1` package."""

    def setUp(self):
        """Set up test fixtures, if any."""

    def tearDown(self):
        """Tear down test fixtures, if any."""

    def test_000_something(self):
        """Test something."""

    def test_command_line_interface(self):
        """Test the CLI."""
        runner = CliRunner()
        result = runner.invoke(cli.main)
        assert result.exit_code == 0
        assert 'recomendation_engine_v1.cli.main' in result.output
        help_result = runner.invoke(cli.main, ['--help'])
        assert help_result.exit_code == 0
        assert '--help  Show this message and exit.' in help_result.output
